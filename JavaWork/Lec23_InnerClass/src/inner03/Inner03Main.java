package inner03;

public class Inner03Main {

	public static void main(String[] args) {
		System.out.println("외부/내부 클래스의 this");
		
		TestOuter out = new TestOuter(100);
		TestOuter.TestInner in1 = out.new TestInner(111);
		in1.printValue();
		
	} // end main()

} // end class Inner03Main

















