package oop05;

// 인터페이스 
// 1. 모든 메소드가 public abstract으로 선언 
// 2. 모든 멤버변수가 public static final로 선언된 
// 특별한 종류의 추상 클래스
// 인터페이스를 구현(상속)할 때는 개수 제한이 없다. (다중상속)
// public abstract, public static final 생략 가능
public class Interface01Main {
	
	public static void main(String[] args) {
		System.out.println("인터페이스");
		
		TestImpl test1 = new TestImpl();
		test1.testAAA();
		test1.testBBB();
		
		System.out.println("\n프로그램 종료");
	}
}

interface TestInterface{
	// 모든 멤버변수가 public static final
	public static final int MIN = 0;
	int MAX = 100;
	
	// 모든 메소드는 public abstract
	public abstract void testAAA();
	void testBBB();
}

class TestImpl implements TestInterface{

	@Override
	public void testAAA() {
		System.out.println("testAAA");
	}

	@Override
	public void testBBB() {
		System.out.println("testBBB");
	}
	
}