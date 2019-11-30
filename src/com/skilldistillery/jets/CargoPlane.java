package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	// constructor
	public CargoPlane(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + " is geting cargo loaded into it.");
	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " is flying now. It has " + this.getFlyingTime() + " hours of fly time.");
	}

}
