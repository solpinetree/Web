package inner03;

public class TestOuter {
	private int value;  // #1
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public class TestInner {
		private int value;	// 	#2
		
		public TestInner(int value) {
			this.value = value;
		}
		
		public void printValue() {
			int value = 10; //#3
			System.out.println("value = "+value);   // 지역변수 #3
			System.out.println("value = "+this.value);	// 내부클래스 멤버 #2
			System.out.println("value = "+TestOuter.this.value); 	// 외부클래스 멤버 #3
		}
	} // end TestInner
	

} // end class TestOuter














