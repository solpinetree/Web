package oop03;

public class Polymorphism03Main {
	public static void main(String[] args) {
		System.out.println("다형성의 어려움");
		
		Vehicle car1 = new Vehicle();
		Vehicle car2 = new Car();
		Vehicle car3 = new HybridCar();
		
		car2.setSpeed(10);  // OK
		// car2.setOil(100);	// X
		// car2는 Vehicle 타입으로 선언되어 있으므로, 
		// Vehicle이 아닌 다른 클래스(자식 클래스)에 정의된 
		// 메소드는 사용할 수 없다. 
		// 따라서, 실제로는 Car 타입 인스턴스로 생성되었지만, 
		// Vehicle 타입 참조변수로는 Car 클래스에 있는 메소드를 사용할 수 없다.
		
		((Car)car2).setOil(100);
		// 실제로 Car 클래스의 인스턴스로 생성된 car2 변수는
		// 형변환을 통해서 Car 타입으로 변환할 수 있고, 
		// Car 클래스에 정의된 메소드를 사용할 수 있다. 

		((car)car1).setOil(100);
		// 실제로 Car 클래스의 인스턴스로 생성된 car2 변수는
		// 형변환을 통해서 Car 타입으로 변환할 수 있고, 
		// Car 클래스에 정의된 메소드를 사용할 수 있다. 
		
	} //end main
}	//end class
