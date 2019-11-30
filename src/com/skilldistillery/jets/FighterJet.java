package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {

	// constructors
	public FighterJet(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(this.getModel() + " is launching it's missles!!!!!");
	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " is flying now. It has " + this.getFlyingTime() + " hours of fly time.");
	}

}
