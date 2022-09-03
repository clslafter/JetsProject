package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImpl;

public class JetsApplication {
	AirField field1 = new AirField();

	public static void main(String[] args) {

		JetsApplication ja = new JetsApplication();
		ja.run();

	}

	private void run() {

		String fileName = "jets.txt";

		field1.setJets(readFromFile(fileName));

//		System.out.println(field1);

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
//				System.out.println(jetClass);

				String jetModel = jetInfo[1];
//				System.out.println(jetModel);

				double jetSpeedInMph = Double.parseDouble(jetInfo[2]);
				int jetRange = (int) Double.parseDouble(jetInfo[3]);
				Long jetPrice = Long.parseLong(jetInfo[4]);

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
		Scanner kb = new Scanner(System.in);

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
				// TODO Auto-generated catch block
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
				
//			case 7:
//				addJetPrompts();
//				field1.addJet();
//				System.out.println();
//				break;
		
			default:
				System.out.println("Please use a number from 1 to 9.");
				System.out.println();
				break;
			}

		} while (entry != 4);

	}

//	private Jet addJetPrompts() {
//			Scanner kb = new Scanner(System.in);
//		
//		
//			System.out.println();
//			System.out.println("Please enter the Jet information."
//					+ "\nTo quit, type quit when prompted for the type");
//			System.out.println();
//			
//			System.out.print("Food Truck Name: ");
//			
//			
//			String name = kb.nextLine();
//			if(name.equalsIgnoreCase("quit")) {
//				break;
//			}
//			
//			System.out.print("Food Truck Type: ");
//			String type = kb.nextLine();
//			
//			
//			System.out.print("Food Truck Rating as a number between 1 and 5: ");
//			int rating = kb.nextInt();
//			kb.nextLine();
//			
//			FoodTruck truck = new FoodTruck(name, type, rating);
//			
//			addTruck(truck);
//		
//	}

}
