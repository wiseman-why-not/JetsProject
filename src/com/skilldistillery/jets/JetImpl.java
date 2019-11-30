package com.skilldistillery.jets;

public class JetImpl extends Jet {

	public JetImpl(String type, String model, double speed, int range, long price) {
		super(type, model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " is flying now. It has " + this.getFlyingTime() + " hours of fly time.");
	}

}
