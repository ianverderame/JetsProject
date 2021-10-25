package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Helicopter;
import com.skilldistillery.jets.entities.Jet;

public class JetsApplication {

	public static void main(String[] args) {
		JetsApplication jetsApp = new JetsApplication();
		ArrayList<Jet> jetList = new ArrayList<Jet>();
		jetsApp.startJetList(jetList);
		AirField airField2 = new AirField();
		airField2.setJets(jetList);
		jetsApp.userMenu(airField2, jetList);
	}

	public void startJetList(ArrayList<Jet> jetList) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			String type;
			String model;
			double speed;
			int range;
			long price;
			while ((line = bufIn.readLine()) != null) {
				String[] lineSplit = line.split(",");
				type = lineSplit[0];
				model = lineSplit[1];
				speed = Double.valueOf(lineSplit[2]);
				range = Integer.valueOf(lineSplit[3]);
				price = Long.valueOf(lineSplit[4]);

				if (type.equals("Helicopter")) {
					Helicopter e = new Helicopter(model, speed, range, price);
					jetList.add(e);
				} else if (type.equals("Fighter")) {
					FighterJet e = new FighterJet(model, speed, range, price);
					jetList.add(e);
				} else if (type.equals("Cargo")) {
					CargoPlane e = new CargoPlane(model, speed, range, price);
					jetList.add(e);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void userMenu(AirField airfield, ArrayList<Jet> jetList) {
		Scanner sc = new Scanner(System.in);
		boolean keepGoing = true;
		System.out.println("========================================");
		System.out.println("|                                      |");
		System.out.println("|                 Menu                 |");
		System.out.println("|                                      |");
		System.out.println("========================================");

		while (keepGoing) {
			System.out.println("\n========================================");
			System.out.println("|      What would you like to do?      |");
			System.out.println("========================================");
			System.out.println("1. List current Fleet");
			System.out.println("2. Fly all jets");
			System.out.println("3. View fastest jet");
			System.out.println("4. View jet with longest range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to the Fleet");
			System.out.println("8. Remove a jet from the Fleet");
			System.out.println("9. Quit");
			char answer = sc.next().charAt(0);
			sc.nextLine();
			switch (answer) {
			case '1':
				airfield.displayJetsInAirField(jetList);
				break;
			case '2':
				airfield.flyMe();
				break;
			case '3':
				fastestJet(airfield, jetList);
				break;
			case '4':
				longestRange(airfield, jetList);
				break;
			case '5':
				loadAllCargoPlanes(airfield, jetList);
				break;
			case '6':
				fighterDogFight(airfield, jetList);
				break;
			case '7':
				addJetToFleet(airfield, jetList, sc);
				break;
			case '8':
				removeJetFromFleet(airfield, jetList, sc);
				break;
			case '9':
				System.out.println("Exiting program...");
				keepGoing = false;
				break;
			default:
				System.out.println("Unreadable input. Please make sure to type 1-9 only");
				break;
			}
		}
		sc.close();
	}

	private void removeJetFromFleet(AirField airfield, ArrayList<Jet> jetList, Scanner sc) {
		System.out.println("Removing jet for maintenance. Which jet would you like to remove?");
		boolean keepGoing = true;
		while (keepGoing) {
			for (int i = 0; i < jetList.size(); i++) {
				Jet jet = jetList.get(i);
				System.out.println((i + 1) + ". " + jet.getModel());
			}
			int ans = sc.nextInt();
			jetList.remove(ans - 1);
			System.out.print("\nWould you like to remove another jet for maintenance?\n1. Yes\n2. No ");
			char ansContinue = sc.next().charAt(0);
			switch (ansContinue) {
			case '1':
				break;
			case '2':
				keepGoing = false;
				break;
			default:
				System.out.println("Unreadable input. Please make sure to type 1-9 only ");
				break;
			}
		}
	}

	private void addJetToFleet(AirField airfield, ArrayList<Jet> jetList, Scanner kb) {
		System.out.println("\nSo, you've bought a jet you want to add to the Fleet? Let's get started.");
		boolean keepGoing = true;
		do {
			System.out.println("What type of jet is this?");
			System.out.println("1. Helicopter\n2. Cargo Plane\n3. Fighter Jet\n4. Whoops, nevermind ");
			String answerInput = kb.nextLine();
			char answer = answerInput.charAt(0);
			if (answer == '4') {
				System.out.println("We all make mistakes...");
				keepGoing = false;
				break;
			} else {
				System.out.print("What is the jets model? ");
				String model = kb.nextLine();
				System.out.print("What is the jets speed in MPH? ");
				double speed = kb.nextDouble();
				System.out.print("What is the jets range in miles? ");
				int range = kb.nextInt();
				System.out.print("What is the jets price (numbers only)? ");
				long price = kb.nextLong();
				kb.nextLine();

				switch (answer) {
				case '1':
					Helicopter h = new Helicopter(model, speed, range, price);
					jetList.add(h);
					break;
				case '2':
					CargoPlane c = new CargoPlane(model, speed, range, price);
					jetList.add(c);
					break;
				case '3':
					FighterJet f = new FighterJet(model, speed, range, price);
					jetList.add(f);
					break;
				default:
					System.out.println("Unreadable input. Please make sure to type 1-9 only");
					break;
				}
				System.out.println("Jet succesfully added!\n");
			}

			System.out.print("Would you like to add another jet to the Fleet?\n1. Yes\n2. No ");
			char ansContinue = kb.next().charAt(0);
			kb.nextLine();
			switch (ansContinue) {
			case '1':
				break;
			case '2':
				keepGoing = false;
				break;
			default:
				System.out.println("Unreadable input. Please make sure to type 1-9 only");
				break;
			}
		} while (keepGoing);
	}

	private void fighterDogFight(AirField airfield, ArrayList<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).dogfight();
			}
		}
	}

	private void loadAllCargoPlanes(AirField airfield, ArrayList<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}

	}

	private void longestRange(AirField airfield, ArrayList<Jet> jetList) {
		Jet longestRangeJet = jetList.get(0);
		for (Jet jet : jetList) {
			if (longestRangeJet.getRange() < jet.getRange()) {
				longestRangeJet = jet;
			}
		}
		System.out.println("\nJet with longest range\n" + longestRangeJet.toString());
	}

	private void fastestJet(AirField airfield, ArrayList<Jet> jetList) {
		Jet fastestjet = jetList.get(0);
		for (Jet jet : jetList) {
			if (fastestjet.getSpeed() < jet.getSpeed()) {
				fastestjet = jet;
			}
		}
		System.out.println("Jet with fastest speed\n" + fastestjet.toString());
	}

}
