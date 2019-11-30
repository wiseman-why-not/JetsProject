package com.skilldistillery.jets;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class JetsApp {
	// field
	private static AirField af = new AirField();
	private static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp newJetApp = new JetsApp();
		newJetApp.run();
		kb.close();
	}

	public void run() {
		List<Jet> list = af.readJet();
		boolean keepGoing = true;
		Integer userChoice = 0;
		do {

			displayMenu();
			System.out.println("Select an option from the menu.");
			userChoice = kb.nextInt();
			kb.nextLine();

			switch (userChoice) {
			case 1:
				listFleet(list);
				break;
			case 2:
				flyAllJets(list);
				break;
			case 3:
				viewFastestJet(list);
				break;
			case 4:
				viewLongestRange(list);
				break;
			case 5:
				loadAllCargoJets(list);
				break;
			case 6:
				dogfight(list);
				break;
			case 7:
				addJet(list);
				break;
			case 8:
				removeJet(list);
				break;
			case 9:
				System.out.println("Quitting Jets App! \nGoodbye!");
				keepGoing = false;
				break;
			}

		} while (keepGoing); // do this loop while keep going is true. only option 9 will return false.
	}

	public void displayMenu() {
		System.out.println();
		System.out.println("**********************************");
		System.out.println("* 1. List fleet                  *");
		System.out.println("* 2. Fly all jets                *");
		System.out.println("* 3. View Fastest Jet            *");
		System.out.println("* 4. View jet with longest range *");
		System.out.println("* 5. Load all Cargo Jets         *");
		System.out.println("* 6. Dogfight!                   *");
		System.out.println("* 7. Add a jet to fleet          *");
		System.out.println("* 8. Remove a jet from the fleet *");
		System.out.println("* 9. Quit                        *");
		System.out.println("**********************************");
	}

	public void listFleet(List<Jet> list) {
		for (Jet jet : list) {
			System.out.println(jet);
		}
	}

	public void flyAllJets(List<Jet> list) {
		for (Jet jet : list) {
			jet.fly();
		}
	}

	public void viewFastestJet(List<Jet> list) {
		double speed = Double.MIN_VALUE;
		Jet fastestJet = null;
		for (Jet jet : list) {

			if (jet.getSpeed() > speed) {
				speed = jet.getSpeed();
				fastestJet = jet;
			}

		}
		System.out.println("Fastest jet is " + fastestJet.toString());
	}

	public void viewLongestRange(List<Jet> list) {
		int range = Integer.MIN_VALUE;
		Jet longestRangeJet = null;
		for (Jet jet : list) {

			if (jet.getRange() > range) {
				range = jet.getRange();
				longestRangeJet = jet;
			}

		}
		System.out.println("Jet with longest range is " + longestRangeJet.toString());
	}

	public void loadAllCargoJets(List<Jet> list) {
		for (Jet jet : list) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void dogfight(List<Jet> list) {
		for (Jet jet : list) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}

	public void addJet(List<Jet> list) {
		Jet newJet = null;
		String newJetType = null;
		String newJetModel = null;
		Double newJetSpeed = null;
		Integer newJetRange = null;
		Long newJetPrice = null;

		System.out.println("What is the type is it? ");
		newJetType = kb.nextLine();
		System.out.println("What is the name of the jet? ");
		newJetModel = kb.nextLine();
		try {
			System.out.println("What is the speed of the jet in mph? ");
			newJetSpeed = kb.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter number(s) and not anything else.");
		}
		try {
			System.out.println("What is the range of the jet in miles? ");
			newJetRange = kb.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please only enter number(s) and not anything else.");
		}
		try {
			System.out.println("what is the price of the jet in dollars? ");
			newJetPrice = kb.nextLong();
		} catch (Exception e) {
			System.out.println("Please only enter number(s) and not anything else.");
		}

		if (newJetType.equalsIgnoreCase("fighter")) {
			newJet = new FighterJet("Fighter", newJetModel, newJetSpeed, newJetRange, newJetPrice);
		} else if (newJetType.equalsIgnoreCase("cargo")) {
			newJet = new CargoPlane("Cargo", newJetModel, newJetSpeed, newJetRange, newJetPrice);
		} else {
			newJet = new JetImpl("JetImpl", newJetModel, newJetSpeed, newJetRange, newJetPrice);
		}

		list.add(newJet);
		System.out.println("Added " + newJet.getModel() + ".");
	}

	public void removeJet(List<Jet> list) {
		Integer count = 1;
		Integer jetToRemove;
		Jet removedJet = null;
		
		for (Jet jet : list) {
			System.out.println(count + " " + jet.getModel());
			count++;
		}
		System.out.println("Please selected a number from 1 - " + (count - 1) + " to remove that jet.");
		jetToRemove = kb.nextInt();
		kb.nextLine();
		removedJet = list.remove(jetToRemove - 1);
		System.out.println("Removed " + removedJet.getModel() + ".");

	}

}
