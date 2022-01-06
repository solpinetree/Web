package oop02;

// 다형성의 유용성
// 다형성에 의해서, 자식타입 객체가 부모타입으로 자동 형변환 가능!
// 부모 타입 만으로도 상속된 모~든 자손 타입들을 담을 수 잇다. 


public class Polymorphism02Main {
	public static void main(String[] args) {
		System.out.println("다형성의 사용(유용성)");
		
		Vehicle car1 =  new Vehicle();
		Vehicle car2 =  new Car();
		Vehicle car3 =  new HybridCar();
		
		// 다형성의 유용함 1
		// 부모타입으로 모든 자손 타입들을 담을 수 있다. 
		Vehicle [] car = new Vehicle[3];
		car[0] = new Vehicle();
		car[1] = new Car();
		car[2] = new HybridCar();
		
		// car 라는 하나의 이름의 변수로 여러가지 타입의 
		// 오버라이딩 된 메소드를 각각 동작시킬 수 있다.
		for (int i = 0; i < car.length; i++) {
			car[i].displayInfo();
		}	// 한가지 타입으로 한꺼번에 처리 가능
		
		// 다형성의 유용함 2
		// 다형성의 유용함은 매개변수, 혹은 리턴 타입에도 적용됨
		driveCar(new Vehicle());
		driveCar(new Car());
		driveCar(new HybridCar());
		
		System.out.println("프로그램 종료");
	}	//	end main
	
	@Override
	public String toString() {
		return "내가 만든 클래스다!~";
	}
	
	public static void driveCar(Vehicle v) {
		v.setSpeed(100);
		v.displayInfo();
	}
}	// end class
