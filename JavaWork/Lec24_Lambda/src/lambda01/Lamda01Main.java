// Lambda01Main.java
package lambda01;

public class Lamda01Main {

	public static void main(String[] args) {
		
		System.out.println("람다 표현식");
		
		System.out.println();
		System.out.println("익명 클래스 사용");
		Addable myAdder2 = new Addable() {

			@Override
			public double add(double x, double y) {
				return x+y;
			}
		};
		double result = myAdder2.add(1.11, 2.22);
		System.out.println("result: "+result);
		
		System.out.println();
		System.out.println("람다 표현식(lambda expression) 사용");
		Addable myAdder3 = (x,y) -> x+y;
		result=myAdder3.add(1.11, 2.22);
		System.out.println("result: "+result);
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class

//인터페이스 정의
interface Addable{
	public abstract double add(double x, double y);
}