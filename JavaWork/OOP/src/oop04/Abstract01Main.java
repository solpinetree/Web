package oop04;

// 추상 클래스를 사용하는 목적
// 추상 클래스를 상속 받는 자식 클래스에 반드시 구현해야 할 메소드가 잇을 경우, 
// 그 메소드를 추상메소드로 만들어서 반드시 override 하도록 하는 목적(강제 overriding)
public class Abstract01Main {
	
	public static void main(String[] args) {
		System.out.println("추상 클래스");
		
		// 추상클래스는 인스턴스 생성 불가! new 불가
		// TestAbstract test1 = new TestAbstract();
		
		// 다형성
		TestAbstract test3 = new TestClass();
		
		System.out.println("\n프로그램 끝");
	}	// end main
}	// end class

abstract class TestAbstract{
	
	int test;
	
	public int getTest() {return test;}
	
	abstract public int testMethod();
}

class TestClass extends TestAbstract{

	@Override
	public int testMethod() {
		// TODO Auto-generated method stub
		return 0;
	}
}

abstract class TestClass2 extends TestAbstract{
	
	int number;
}