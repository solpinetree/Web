package phonebook03.file;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//VIEW : (PhonebookMainView)와 Controller(PhonebookController) 사이의 인터페이스
//애플리케이션의 동작(business logic) 정의
public class PhonebookController implements Controller, C, Closeable {

	// 데이터
	private List<PhonebookModel> pbList = new ArrayList<>();
	
	// 저장할 파일에 대한 변수
	private static final String DATA_DIR = "data";
	private static final String DATA_FILE = "phonebook.dat";
	private File pbDir;
	private File pbFile;
	
	// singleton 디자인패턴 적용
	private PhonebookController() {	// 최초에 단 한번 시작함
		// 프로그램 시작시
		// - 폰북이 저장될 디렉토리가 없으면 새로 생성, 데이터 파일 없으면 생성
		// - 데이터 파일 있으면 읽어 들어와서 데이터 파일 저장 -> List
		// - 프로그램 종료시 List -> 데이터 파일 저장 
		// - 필요한 메소드 등이 필요하면 추가로 작성하세요. 단 privatefh!
		
		initFile();
	}	
	
	private static PhonebookController instance = null;
	public static PhonebookController getInstance() {
		if(instance == null) instance = new PhonebookController();
		return instance;
 	} // end getInstance()
	
	private void initFile() {
		// 1. 데이터 저장 폴더 생성(없었다면!)
		// 1. 데이터 저장 폴더 생성(없었다면!)
		pbDir = new File(System.getProperty("user.dir")+
					File.separator+DATA_DIR);
		if(!pbDir.exists()) {
			if(pbDir.mkdir()) {
				System.out.println("폴더 생성 성공!");
			} else {
				System.out.println("폴더 생성 실패!");
			}
		}
				
		// 2. 데이터 저장 파일 생성(없었다면!)
		
		File pbFile = new File(pbDir, DATA_FILE);
		if(!pbFile.exists()) {
			try {
				if(pbFile.createNewFile()) {  // 물리적으로 파일 생성
					System.out.println("파일 생성 성공");
				} else {
					System.out.println("파일 생성 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	    try(
				InputStream in = new FileInputStream(pbFile.getAbsolutePath());
				ObjectInputStream oin = new ObjectInputStream(in);
				) {
				
			PhonebookModel dataRead;
			// 파일의 내용을 읽어와서 --> pbList에 담기
			while(true) {
				dataRead = (PhonebookModel)oin.readObject();
				pbList.add(dataRead);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(EOFException e) {
			System.out.println("데이터 로딩 완료!");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 

	}
	
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		int result = 0;
		
		// 매개변수 검증 : 이름, 전화번호 필수
		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("insert() 이름입력 오류: ", ERR_EMPTY_STRING);
		if(phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("insert() 전화번호입력 오류: ", ERR_EMPTY_STRING);
		
		
		PhonebookModel pb = new PhonebookModel(
				getMaxUid() + 1 // uid 값 (unique 한 값)
				, name // 이름
				, phoneNum // 전화번호
				, memo // 메모
				, LocalDateTime.now()// 시간
				);
		
		pbList.add(pb);  // List<> 에 추가
		result = 1;
		
		return result;
	}

	// ※ 컨트롤러에서만 사용하는 메소드는 private 으로 만들자
	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {
		if(pbList.size() == 0) return 0;
		
		// List<> 로 저장되는 경우 가장 마지막 요소의 Uid값이 최대값
		return pbList.get(pbList.size() - 1).getUid();
	} 


	@Override
	public List<PhonebookModel> selectAll() {
		return pbList;
	}

	@Override
	public PhonebookModel selectByUid(int uid) {
	
		int index = findIndexByUid(uid);
		if(0 <= index) return pbList.get(index);  // uid값 발견하면 model 리턴
		
		throw new PhonebookException("존재하진 않는 uid : " + uid, ERR_INVALID_UID);
	}

	// List 의 경우, 특정 uid 를 가진 데이터의 index  값을 알아야 한다.
	private int findIndexByUid(int uid) {
		
		for(int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid){
				return index;
			}
		}	
		
		return -1;    // 못찾으면 -1
	}


	@Override
	public int update(int uid, String name, String phoneNum, String memo) {
		int result = 0;
		
		// 매개변수 검증 : 이름, 전화번호 필수
		if(name == null || name.trim().length() == 0)
			throw new PhonebookException("update() 이름입력 오류: ", ERR_EMPTY_STRING);
		if(phoneNum == null || phoneNum.trim().length() == 0)
			throw new PhonebookException("update() 전화번호입력 오류: ", ERR_EMPTY_STRING);
		
		// 우전 존재하는 uid 여부 확인
		PhonebookModel pb = selectByUid(uid);
		if(pb != null) {
			pb.setName(name);
			pb.setPhoneNum(phoneNum);
			pb.setMemo(memo);
			result = 1;
		}
		
		return result;
	}

	@Override
	public int delete(int uid) {
		int result = 0;
		
		int index = findIndexByUid(uid);
		if(index < 0)
			throw new PhonebookException("delete() 존재하지 않는 uid : " + uid, ERR_INVALID_UID);
		
		if(index >= 0) {
			pbList.remove(index);
			result = 1;
		}
		
		return result;
	}


	@Override
	public void close() throws IOException {
		// TODO : pbList -> 파일로 저장 
		OutputStream out = new FileOutputStream(System.getProperty("user.dir")+
				File.separator+DATA_DIR+File.separator+DATA_FILE);
		ObjectOutputStream oout = new ObjectOutputStream(out);
		
		for(PhonebookModel m : pbList) {
			oout.writeObject(m);
		}
		
		oout.flush();
		oout.close();
		
	}

}
















