package wrapper2;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 = 10;	// auto-boxing
		Integer num2 = 20;
		Integer num3 = num1 + num2;
		// Integer num3 = Integer.valueOf(num1.intValue()+num2.intValue()); // unboxing

		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것

		// TODO

		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		Integer num5 = 200;
		int n5 = num5; // auto-unboxing
		

		System.out.println();
		System.out.println("wrapper 클래스들");

		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
