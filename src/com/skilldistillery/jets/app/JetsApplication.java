package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;
import com.sun.glass.ui.Pixels.Format;

public class JetsApplication {
	AirField field1 = new AirField();
	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		JetsApplication ja = new JetsApplication();
		ja.run();

		ja.kb.close();

	}

	private void run() {

		String fileName = "jets.txt";

		field1.setJets(readFromFile(fileName));

		jetsAppMenu();

	}

	public List<Jet> readFromFile(String fileName) {
		List<Jet> jetList = new ArrayList<>();

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetInfo = line.split(",");

				Jet newJet = null;

				String jetClass = jetInfo[0];

				String jetModel = jetInfo[1];

				double jetSpeedInMph = Double.parseDouble(jetInfo[2]);
				int jetRange = (int) Double.parseDouble(jetInfo[3]);
				long jetPrice = Long.parseLong(jetInfo[4]);

				if (jetClass.equalsIgnoreCase("CargoPlane")) {
					newJet = new CargoPlane(jetModel, jetSpeedInMph, jetRange, jetPrice);
				} else if (jetClass.equalsIgnoreCase("FighterJet")) {
					newJet = new FighterJet(jetModel, jetSpeedInMph, jetRange, jetPrice);
				} else {
					newJet = new JetImpl(jetModel, jetSpeedInMph, jetRange, jetPrice);
				}

				jetList.add(newJet);

			}
		} catch (IOException e) {
			System.err.println(e);
		}

		return jetList;
	}

	private void jetsAppMenu() {

		System.out.println();
		System.out.println("Please choose an option from the following menu");
		System.out.println();

		int entry = 0;

		do {
			System.out.println("1. List fleet.");
			System.out.println("2. Fly all jets.");
			System.out.println("3. View the fastest jet.");
			System.out.println("4. View jet with the longest range.");
			System.out.println("5. Load all Cargo Jets.");
			System.out.println("6. Dogfight!");
			System.out.println("7. Add a jet to the Fleet.");
			System.out.println("8. Remove a jet from Fleet.");
			System.out.println("9. Quit the program.");
			System.out.println();

			try {
				entry = kb.nextInt();
			} catch (InputMismatchException e) {

				System.err.println("Oops. That's an invalid entry. Please try again.");
				entry = 0;
				kb.nextLine();
			}

			switch (entry) {
			case 1:
				field1.displayJets(field1.getJets());
				System.out.println();
				break;

			case 2:
				field1.flyAllJets(field1.getJets());
				System.out.println();
				break;

			case 3:
				field1.displayFastestJet(field1.getJets());
				System.out.println();
				break;

			case 4:
				field1.displayLongestRangeJet(field1.getJets());
				System.out.println();
				break;

			case 5:
				field1.loadAllCargoJets(field1.getJets());
				System.out.println();
				break;

			case 6:
				field1.dogFight(field1.getJets());
				System.out.println();
				break;

			case 7:
				field1.addJet(addJetPrompts());
				System.out.println();
				break;

			case 8:

				int jetToRemove = removeJetPrompts();

				if (jetToRemove < field1.getSize() && jetToRemove > -1) {
					field1.removeJet(jetToRemove);
				} else {
					System.out.println("That Jet does not exist in the fleet.");
				}
				System.out.println();
				break;
				
			case 9:
				
				System.out.println("Thank you. Have a nice flight.");
				break;

			default:
				System.out.println("Please use a number from 1 to 9.");
				System.out.println();
				break;
			}

		} while (entry != 9);

	}

	private Jet addJetPrompts() {

		Scanner kb = new Scanner(System.in);
		Jet newJet = new JetImpl();

		while (true) {

			System.out.println();
			System.out.println("What type of jet would you like to add?"
					+ "\nTo return to the previous menu, type \"quit\" at any time");
			System.out.println();
			System.out.println("1. Cargo Plane");
			System.out.println("2. Fighter Jet");
			System.out.println("3. Any other type of jet.");
			System.out.println();

			String jetType = kb.nextLine();

			if (jetType.equalsIgnoreCase("quit")) {
				break;
			} else {
				switch (jetType) {
				case "1":
					newJet = new CargoPlane();
					break;

				case "2":
					newJet = new FighterJet();
					break;

				case "3":
					newJet = new JetImpl();
					break;

				default:
					System.out.println("Invalid entry. Please choose 1, 2, or 3.");
					System.out.println();
					break;

				}

			}

			System.out.println();

			System.out.print("Enter Jet Model: ");

			String model = kb.nextLine();
			if (model.equalsIgnoreCase("quit")) {
				break;
			} else {
				newJet.setModel(model);
			}

			System.out.print("Enter Jet Speed in Miles Per Hour: ");
			String speed = kb.nextLine();

			if (speed.equalsIgnoreCase("quit")) {
				break;
			} else {

				double speedInMph = 0;
				try {
					speedInMph = Double.parseDouble(speed);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.err.println(
							"Sorry. Your entry is not in the correct format. Nothing has been added to this field.");
				}

				newJet.setSpeedInMph(speedInMph);
			}

			System.out.print("Enter Jet Range in Miles: ");
			String jetRange = kb.nextLine();

			if (jetRange.equalsIgnoreCase("quit")) {
				break;
			} else {

				int range = 0;
				try {
					range = (int) Double.parseDouble(jetRange);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.err.println(
							"Sorry. Your entry is not in the correct format. Nothing has been added to this field.");
				}

				newJet.setRange(range);
			}

			System.out.print("Enter Jet Price: ");
			String jetPrice = kb.nextLine();

			if (jetPrice.equalsIgnoreCase("quit")) {
				break;
			} else {

				long price = 0L;
				try {
					price = (long) Long.parseLong(jetPrice);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					System.err.println(
							"Sorry. Your entry is not in the correct format. Nothing has been added to this field.");
				}

				newJet.setPrice(price);
			}

			System.out.println(newJet + " added");
			break;
		}

		return newJet;

	}

	private int removeJetPrompts() {

		System.out.println("Please choose the number of the Jet you wish to remove from the following list:"
				+ "to return to the previous menu, type any letter.");
		System.out.println();

		field1.displayJets(field1.getJets());
		System.out.println();

		int idx = -1;

		try {

			idx = kb.nextInt();
		} catch (InputMismatchException e) {
			idx = -1;
			kb.nextLine();
		}
		if (idx < field1.getSize() && idx > -1) {
			System.out.println("Removed: " + field1.getJet(idx));
		}

		return idx;
	}

}
