package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {
	
	// constructor
	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {
		System.out.println("Loading Cargo plane with cargo");
	}

}
