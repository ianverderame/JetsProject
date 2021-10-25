package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements CargoCarrier {
	private static String type = "Cargo Plane";

	public CargoPlane() {
		super();
	}

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public void flyMe() {

	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		CargoPlane.type = type;
	}

	@Override
	public void loadCargo() {
		System.out.println("\nPreparing " + CargoPlane.this.getModel() + " to load cargo");
		System.out.println("Loading cargo.");
		System.out.println("Loading cargo..");
		System.out.println("Loading cargo...");
		System.out.println("Loading cargo....");
		System.out.println("Cargo loaded. Ready for transport.");
	}

}
