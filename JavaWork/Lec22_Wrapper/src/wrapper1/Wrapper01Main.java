package wrapper1;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double

	Wrapper 클래스는 String 과 마찬가지로 Immutable(불변) 이다. 
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();

		// 1. 생성자 이용
		// TODO
		Integer num1 = new Integer(123);

		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		// TODO
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);

		System.out.println(num1 == num2); // wrapper 끼리의 == 비교연산은 주소비교 . false
		System.out.println(num1.equals(num2)); // 내용비교, . true

		// 3. new Integer() VS Integer.valueOf()
		// TODO
		Integer num4 = Integer.valueOf(123);

		System.out.println(num1 == num4); // false
		System.out.println(num2 == num4); // true
		// valueOf() 는 Object를 cache 해둔다. 같은 Literal로 생성하면 같은 Object.
		// 메모리 절약 차원

		// 4. literal 상수로 생성
		// TODO
		System.out.println();
		Integer num5 = 123; // auto-boxing
		System.out.println(num4 == num5); // 같은 참조(주소)

		// 5. valueOf(문자열) 가능!
		// TODO
		Integer num6 = Integer.valueOf("123");
		System.out.println(num4 == num6);

		// 6. 산술 연산 가능
		// TODO
		num6 *= 2;
		System.out.println(num6);

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
