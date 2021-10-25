package com.skilldistillery.jets.entities;

import java.util.ArrayList;

public class AirField {

	private ArrayList<Jet> jets;

	public ArrayList<Jet> getJets() {
		return jets;
	}

	public void setJets(ArrayList<Jet> jets) {
		this.jets = jets;
	}

	public AirField() {

	}

	public void displayJetsInAirField(ArrayList<Jet> jets) {
		System.out.println(
				"---------------------------------------CURRENT AIRFIELD------------------------------------------\n");
		for (Jet jet : jets) {
			System.out.println(jet);
			System.out.println("-------------------------------------------------------------------------------------------------");
		}
	}

	public void flyMe() {
		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				System.out.println("Brrrrrr I'm a " + jet.getModel() + " " + CargoPlane.getType() + "! I can fly for "
						+ jet.fly(jet.getRange(), jet.getSpeed()) + " hours at top speed!");
			} else if (jet instanceof FighterJet) {
				System.out.println("Brrrrrr I'm a " + jet.getModel() + " " + FighterJet.getType() + "! I can fly for "
						+ jet.fly(jet.getRange(), jet.getSpeed()) + " hours at top speed!");
			} else if (jet instanceof Helicopter) {
				System.out.println("Brrrrrr I'm a " + jet.getModel() + " " + Helicopter.getType() + "! I can fly for "
						+ jet.fly(jet.getRange(), jet.getSpeed()) + " hours at top speed!");
			}

		}

	}

}
