package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {

	public JetImpl(String model, double speedInMph, int range, long price) {
		super(model, speedInMph, range, price);
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
