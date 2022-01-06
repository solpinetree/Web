package oop01;

public class Car extends Vehicle{
	// 멤버변수
	private int oil;

	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}
	
	@Override
	public void displayInfo() {
		System.out.println("--- Car 정보 ---");
		System.out.println("speed: " + getSpeed());
		System.out.println("oil: " + oil);
	}
}







