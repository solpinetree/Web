package exception01;

import java.util.Scanner;

/* 예외(Exception)
	
	컴파일 에러 : 문법상 오류
	예외(Exception) : 문법상의 오류 가 아닌 '실행중' 에 발생되는 오류상황
	  
	(기본적으로) 예외 가 발생되면, 예외 관련 메세지 출력하고 프로그램이 종료 됩니다.  
 */
public class Exception01Main {

	public static void main(String[] args) {
		System.out.println("예외(Exception)");
		
		System.out.println("[1] ArithmeticException");
		int num1 = 123;
		int num2 = 0;

		//System.out.println(num1 / num2);
		
		System.out.println("[2] ArrayIndexOutOfBoundsException");
		int[] numbers = new int[10];
		
		//numbers[10] = 100;
		
		System.out.println("[3] NegativeArraySizeException");

		//int [] numbers2 = new int[-1];
		
		System.out.println("[4] NullPointerException(NPE)");
		String str = null;
		
//		str.length();   => 어떤 객체로 레퍼런식 하고 있지 않기때문에 주소도 생성안된상태
		// aaa.bbb;
		// NPE 발생하면 ' . ' 의 왼쪽이 null 인지 확인하자!!!
		// aaa.bbb().ccc;
	
		
		
		System.out.println("[5] InputMismatchException");  
		Scanner sc = new Scanner(System.in);
	
		sc.nextInt();
		
		sc.close();
		

	} // end main()

} // enc class Exception01Main












