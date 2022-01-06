package file06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream
*/

public class File06Main {

	public static void main(String[] args) {
		System.out.println("Data Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream("temp1/data.bin");
				DataOutputStream dout = new DataOutputStream(out);
				InputStream in = new FileInputStream("temp1/data.bin");
				DataInputStream din= new DataInputStream(in);
				)
		{
			dout.writeBoolean(true);	//1byte
			dout.writeInt(100);	// 4byte
			dout.writeDouble(3.14);	// 8byte
			dout.writeChar('a');	// 2byte
			
			
			boolean b = din.readBoolean();
			System.out.println("boolean: "+b);
			
			System.out.println("int: "+din.readInt());
			
			System.out.println("double: "+din.readDouble());

			System.out.println("char: "+din.readChar());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















