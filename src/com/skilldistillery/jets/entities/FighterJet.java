package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double speed, int range, long price) {
		super();

	}

	@Override
	public void fight() {
		System.out.println("Contact with enemy fighter. " + super.getModel() + " engaging.");
		System.out.println("Enemy fighter vanquished. Fight is over.");

	}

//	@Override
//	public void fly() {
//		// TODO Auto-generated method stub
//
//	}

}
