package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class AirField {

	private List <Jet> jets;
	

	
	public AirField() {
	    jets = new ArrayList<>();
	  }
	
	public Jet addJet(Jet j) {
	    jets.add(j);
	   
	  
	    return j;
	}
	  
	public List <Jet> getJets() {
		  List <Jet> jetCopy;
	    jetCopy =  new ArrayList<>();
	    
	    Iterator <Jet> it = jets.iterator();
		while(it.hasNext()) {
			Jet nextJet = it.next();
			jetCopy.add(nextJet);
		}
	    
	    return jetCopy;
	  }
	  
	public Jet removeJet (int idxNum) {
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




	
	
}
