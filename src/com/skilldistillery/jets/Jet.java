package com.skilldistillery.jets;

public abstract class Jet {
	// fields
	private String model;
	private double speed;
	private int range;
	private long price;
	private double machSpeed;
	private double flyingTime;

	// constructors
	public Jet() {

	}

	public Jet(String type, String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.machSpeed = (speed * 0.001303);
		this.flyingTime = (range / speed);
	}

	// methods

	public void fly() {

	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet model = " + model + ", speed = " + speed + ", machSpeed = " + machSpeed + ", range = " + range
				+ ", price = " + price + ". The amount of flight time is " + flyingTime + " hours.";
	}

	public double getMachSpeed() {
		return machSpeed;
	}

	public void setMachSpeed(double machSpeed) {
		this.machSpeed = machSpeed;
	}

	public double getFlyingTime() {
		return flyingTime;
	}

	public void setFlyingTime(double flyingTime) {
		this.flyingTime = flyingTime;
	}
}
