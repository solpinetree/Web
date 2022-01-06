package inner02;


public class Car {
	// 멤버 변수( outer )
	private String color;
	
	// 생성자
	public Car(String color) {
		this.color = color;
	}
	
	// 메소드
	public void displayCarInfo() {
		System.out.println("color: " + color);
	}
	
	// 멤버 내부 클래스 
	public class Tire{
		private int radius;
		
		public Tire(int radius) {
			this.radius = radius;
		}
		
		public void displayInfo() {
			System.out.println("---타이어 정보---");
			System.out.println("차량 color: "+ color);
			System.out.println("tire: "+ radius);
		}
	}
	
} // end class Car











