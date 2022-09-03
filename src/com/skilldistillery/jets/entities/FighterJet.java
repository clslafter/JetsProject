package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speedInMph, int range, long price) {
		super(model, speedInMph, range, price);

	}

	@Override
	public void fight() {
		System.out.println("Contact with enemy fighter. " + super.getModel() + " engaging.");
		System.out.println("Enemy fighter vanquished. Fight is over.");

	}

	public void fly() {
		double flyingTime = super.getRange() / super.getSpeedInMph();
		System.out.printf("The " + 
						super.getModel() +	" " +
						getClass().getSimpleName() +
						" with an average speed of " +
						super.getSpeedInMph() + 
						" and a range of " + 
						super.getRange() + 
						" is flying. It has a maximum flying time of %.2f hours.", flyingTime);
		System.out.println();
	
	}

}
