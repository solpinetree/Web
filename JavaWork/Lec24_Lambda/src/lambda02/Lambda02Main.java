package lambda02;

/*	람다 표현식 (lambda - expression): 
	 	() -> 수행코드
	 	() -> 리턴값
	 	(매개변수..) -> 수행코드
	 	(매개변수..) -> 리턴값
	 	
	 매개변수의 타입은 생략해서 표현이 가능
	 매개변수가 여러개 있을 경우,
		 모든 매개변수의 타입을 생략해서 표현하거나,
		 모든 매개변수의 타입을 모두 다 표현해야 함. 
*/
public class Lambda02Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		
		// 매개변수 없고, 리턴값도 없는 경우
//		Test01 lambda01 = () -> System.out.println("안녕하세요");
//		lambda01.testPrint();
		
		// 매개변수 한개, 리턴값은 없는 경우
		// TODO
		
		// 매개변수 여러개, 리턴값이 있슴.
		Test03 lambda03 = (x,y) -> (x>y)?x:y;
		System.out.println("result: "+lambda03.max(10, 20));
		
		// 매개변수 한개, 내부 수행코드 여러줄.., 리턴값.
		Test04 lambda04 = (x) -> {
			System.out.println(x);
			return x.length();
		};
		System.out.println("result: "+lambda04.myStrlen("Java"));
		
		// Test05 인터페이스 만들기
		// void printMax(double x, double y)
		// [출력양식 예제]
		// x = 3.14
		// y = 1.2
	    // 3.14 > 1.2
		Test05 lambda05 = (x,y) -> {
			System.out.print(x+" 와 "+ y+" 중 더 큰 수는 ");
			if(x>y)
				System.out.println(x);
			else
				System.out.println(y);
		};
		lambda05.printMax(2.4, 3.5);

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















