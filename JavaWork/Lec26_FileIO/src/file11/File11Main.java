package file11;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

/*
문자(character) 단위 입출력 스트림 클래스
 java.io.Reader: 프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
  └─ java.io.InputStreamReader
      └─ java.io.FileReader

 java.io.Writer: 프로그램이 '문자 단위' 데이터를 쓰는(write) 통로
  └─ java.io.OutputStreamWriter
      └─ java.io.FileWriter

 FileReader / FileWriter 객체는 '텍스트파일, 즉 문자 단위' 데이터를 읽고/쓰기 할때
 사용하는 기반 스트립 입니다.   따라서 텍스트가 아닌 오디오, 비디오, 등의 파일을 다룰수 없습니다.
 주로 String 이나 char [] 내용을 입/출력 할때 사용합니다.

 텍스트 파일 (Text File) 이란
   사람이 읽을수 있는 글자들이 저장된 파일
   암호화 되지 않은 평범한 텍스트

 이진파일 (Binary File) 이란
   사람이 직접 읽을수는 없슴.

   ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★
*/


public class File11Main {
	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");
		
		String src = "temp1/FileData.txt";
		String dst = "temp1/FileData.txt";
		
		try(
				FileWriter fw = new FileWriter(dst);
				FileReader fr = new FileReader(src);
				){
			String str = "안녕하세요";
			char [] charArr = {'J','V','A','A'};
			// utf-8 인코딩의 경우 한글 한글자당 3바이트
			
			fw.write(str);
			fw.write(charArr);
			fw.flush();	// write() 메소드를 호출한 후에는 flush() 메소드로 출력버퍼의 데이터를 완전히 출력(비움)
			
			// 읽기(read)
			char [] buff = new char[100];
			int charsRead = 0; // 읽어드린 문자의 개수
			charsRead = fr.read(buff);
			for(int i=0;i<charsRead;i++) {
				System.out.print(buff[i]);
			}
			System.out.println();
			System.out.println("읽은 문자 개수 : "+ charsRead);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()
} // end class
