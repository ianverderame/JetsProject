package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady{
	private static String type = "Fighter Jet";

	public FighterJet() {
		super();
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	public static String getType() {
		return type;
	}

	public static void setType(String type) {
		FighterJet.type = type;
	}

	@Override
	public void dogfight() {
		System.out.println("\nPreparing " + FighterJet.this.getModel() + " for combat... Strap in, pilot");
		System.out.println("DOGFIGHT!!!");
		System.out.println("VROOOOM");
		System.out.println("BLAM");
		System.out.println("POW");
		System.out.println("Combat over! " + FighterJet.this.getModel() + " is victorious!");
	}

	
}
