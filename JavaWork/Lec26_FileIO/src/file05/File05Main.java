package file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* Buffered Stream + Buffer 예제
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream
*/

public class File05Main {

	public static void main(String[] args) {
		System.out.println("Buffered Stream + Buffer");
		
		// TODO:
		// file03 패키지 참조
		// try with resource 구문으로 작성
		// in.read(buff) --> bin.read(buff);
		// out.write( , , ) --> bout.write( , , ); 사용
		// finally 필요 없슴
		
		
		try(
				InputStream in = new FileInputStream("temp1/big_text.txt");
				BufferedInputStream bin = new BufferedInputStream(in);
				OutputStream out = new FileOutputStream("temp1/copy_big_text.txt");
				BufferedOutputStream bout = new BufferedOutputStream(out);
				)
			{
				byte [] buff = new byte[1024];	//	버퍼 준비
				int byteCopied = 0;
				int lengthRead =0;
				
				long startTime = System.currentTimeMillis();
				
				while(true) {
					// 데이터 읽기 
					lengthRead = bin.read(buff);
					if(lengthRead==-1)	break;
					
					// 데이터 쓰기
					bout.write(buff, 0, lengthRead);	//  직전에 읽어들인 데이터만큼 write
					byteCopied +=lengthRead;
				}

				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime-startTime;
				
				System.out.println();
				System.out.println(elapsedTime);
				
			}catch(FileNotFoundException e){
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class File05Main
















