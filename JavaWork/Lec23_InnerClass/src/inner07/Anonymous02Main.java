package inner07;

public class Anonymous02Main {

	public static void main(String[] args) {
		System.out.println("익명 내부 클래스 활용");
		
		System.out.println();
		
		System.out.println("1. 익명클래스 사용하지 않는 경우");
		Calculable tc1 = new TestMyMyth();
		double result = tc1.operate(1., 2.);
		System.out.println("result = "+result);

		System.out.println();
		System.out.println("2. 익명클래스 사용");
		Calculable tc2 = new Calculable() {
			
			@Override
			public double operate(double x, double y) {
				return x+y;
			}
		};
		
		System.out.println("result = "+tc2.operate(1.,  2.));
		
		result = new Calculable() {

			@Override
			public double operate(double x, double y) {
				return x*y;
			}
			
		}.operate(2.0, 3.0);
		System.out.println("result: "+result);
		
	} // end main()

} // end class Anonymous02Main

interface Calculable {
	public abstract double operate(double x, double y);
}


/*
위와 같이 특정 추상 메소드만 implement 하는 목적으로 설계되는 인터페이스의 이름은
보통 ~ able 로 작명 경우가 많다.  
자바에서 제공하는 대표적으로 많이 사용하는 이러한 인터페이스들.
Serializable, Cloneable, Readable, Appendable, Closeable,  
AutoCloseable, Observable, Iterable, Comparable, Runnable,
Callable, Repeatable, 
*/

class TestMyMyth implements Calculable{

	@Override
	public double operate(double x, double y) {
		return x+y;
	}
	
}