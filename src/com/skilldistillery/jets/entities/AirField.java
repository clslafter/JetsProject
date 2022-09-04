package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class AirField {

	private List<Jet> jets;

	public AirField() {
		jets = new ArrayList<>();
	}

	public Jet addJet(Jet j) {
		jets.add(j);

		return j;
	}

	public void setJets(List<Jet> jetList) {
		jets = jetList;

	}

	public List<Jet> getJets() {
		List<Jet> jetCopy;
		jetCopy = new ArrayList<>();

		Iterator<Jet> it = jets.iterator();
		while (it.hasNext()) {
			Jet nextJet = it.next();
			jetCopy.add(nextJet);
		}

		return jetCopy;
	}

	public Jet removeJet(int idxNum) {
		return jets.remove(idxNum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(jets);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		return Objects.equals(jets, other.jets);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AirField [jets=").append(jets).append("]");
		return builder.toString();
	}

	public void displayJets(List<Jet> jets) {
		for (int i = 0; i < jets.size(); i++) {
			System.out.println(i + " " + jets.get(i));
			;
		}

	}

	public void flyAllJets(List<Jet> jets) {
		for (int i = 0; i < jets.size(); i++) {
			jets.get(i).fly();
		}
	}

	public void displayFastestJet(List<Jet> jets) {
		Jet fastestJet = new FighterJet(null, 0, 0, 0);

		for (Jet jet : jets) {
			if (fastestJet.getSpeedInMph() < jet.getSpeedInMph()) {
				fastestJet = jet;
			}

		}
		System.out.println(fastestJet);

	}

	public void displayLongestRangeJet(List<Jet> jets) {
		Jet longestRangeJet = new FighterJet(null, 0, 0, 0);

		for (Jet jet : jets) {
			if (longestRangeJet.getRange() < jet.getRange()) {
				longestRangeJet = jet;
			}

		}
		System.out.println(longestRangeJet);

	}

	public void loadAllCargoJets(List<Jet> jets) {

		for (Jet jet : jets) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}

	}

	public void dogFight(List<Jet> jets) {
		
		for (Jet jet : jets) {
			if (jet instanceof FighterJet) {
				((FighterJet) jet).fight();
			}
		}
	}

	public Jet getJet(int idx) {
		
		return jets.get(idx);
	}

	public int getSize() {
		
		return jets.size();
	}
}
