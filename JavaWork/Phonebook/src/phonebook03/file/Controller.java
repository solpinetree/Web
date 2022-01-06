package phonebook03.file;

import java.util.List;

//VIEW : (PhonebookMainView)와 Controller(PhonebookController) 사이의 인터페이스
//애플리케이션의 동작(business logic) 정의
public interface Controller {

	// 동작설계
	
	// 이름(name), 전화번호(phonenum), 메모(memo) 를 받아서 전화번호부 데이터 생성 저장
	public abstract int insert(String nmae, String phoneNum, String memo); // 정상적으로 저장하면 1 리턴 or 0 리턴
	
	// 데이터 전체 목록 읽어오는 동작
	public abstract List<PhonebookModel> selectAll();
	
	// 특정 uid의 데이터 한개 읽어오기
	public abstract PhonebookModel selectByUid(int uid); // 해당 uid의 데이터가 없으면 null 리턴
	
	// 특장 uid의 데이터를 주어진 이름(name), 전화번호(phonenum), 메모(memo)로 수정하기
	public abstract int update(int uid, String name, String phoneNum, String memo);// 정상적으로 저장하면 1 리턴 or 0 리턴
	
	// 특정 uid의 데이터 삭제하기
	public abstract int delete(int uid); // 정상적으로 삭제하면 int값 1 리턴. 아니면 0 리턴
	
}
