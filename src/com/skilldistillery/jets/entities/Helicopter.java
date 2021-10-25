package com.skilldistillery.jets.entities;

public class Helicopter extends Jet {
	 private static String type = "Helicopter";
	
	public Helicopter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Helicopter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		Helicopter.type = type;
	}

}
