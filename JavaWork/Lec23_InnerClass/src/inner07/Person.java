package inner07;

public class Person {
	
	// 외부 클래스 멤버변수
	private String name;
	
	// 외부 클래스 생성자
	public Person(String name) {
		this.name = name;
	}
	
	public MyReadable createInstance(int age) {
		
		// MyReadable 을 Implement한 instance 생성
		// 익명클래스 구문 사용!!
//		MyReadable r = new MyReadable() {
//
//			@Override
//			public void readInfo() {
//				System.out.println("이름: "+name);
//				System.out.println("나이: "+age);
//			}
//			
//		};
		
		// 익명 내부 클래스:
		// 인스턴스 생성과 동시에 클래스가 정의됨.
		// new 인터페이스() { 익명 클래스 내부 작성 }; 
		// new 부모클래스() { 익명 클래스 내부 작성 };
		
		return new MyReadable() {
			
			@Override
			public void readInfo() {
				System.out.println("이름: "+name);
				System.out.println("나이: "+age);
			}
		};
	}
	
} // class Person


interface MyReadable{
	void readInfo();
}









