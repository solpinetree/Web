package file16;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";
	
	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		System.out.println();
		String path = System.getProperty("user.dir")
				+ File.separator		// Windows( \) , UNIX( /)
				+ TEST_DIRECTORY;
		System.out.println(path);
		
		// 경로를 사용해서 File 객체 생성
		File f = new File(path); // 물리적인 파일이나 디렉토리가 생성되는 것은 아님 
		
		System.out.println();
		// 폴더 생성: mkdir()
		if(!f.exists()) { // 폴더가 존재하는지 체크
			// 폴더가 없다면
			if(f.mkdir()) {
				System.out.println("폴더 생성 성공!");
			}else {
				System.out.println("폴더 생성 실패!");
			}
		}else {
			System.out.println("폴더가 이미 존재합니다");
		}
		
		System.out.println();
		// 파일 생성 : createNewFile()
		File f2 = new File(f, TEST_FILE); // File(디렉토리 File객체, 파일명)
		System.out.println(f2.getAbsolutePath());
		
		if(!f2.exists()) {
			// 파일이 존재하지 않으면 생성
			try {
				if(f2.createNewFile()){// 물리적으로 파일 생성
					System.out.println("파일 생성 성공");
				}else {
					System.out.println("파일 생성 실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("파일이 이미 존재합니다.");
		}
		
		System.out.println();
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		File f3 = new File(f, TEST_RENAME); // 변경할 이름
		System.out.println(f3.getAbsolutePath());
		
		if(f2.exists()) {
			// 파일이 존재할때만 이름 변경
			if(f2.renameTo(f3)) {
				System.out.println("파일 이름 변경 성공!");
			}else {
				System.out.println("파일 이름 변경 실패!");
			}
		}else {
			System.out.println("변경할 파일이 없습니다.");
		}
		
		System.out.println();
		// 파일 삭제: delete()
		// TODO
	
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class














