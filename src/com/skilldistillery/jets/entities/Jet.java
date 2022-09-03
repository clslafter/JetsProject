package com.skilldistillery.jets.entities;

import java.util.Objects;

public abstract class Jet {

	private String model;
	private double speedInMph;
	private int range;
	private long price;

	public Jet() {
	}

	public Jet(String model, double speedInMph, int range, long price) {
		super();
		this.model = model;
		this.speedInMph = speedInMph;
		this.range = range;
		this.price = price;
	}

	public String fly() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("The ").append(model).append(" of ").append(getClass()).append(" with an average speed of ")
		.append(speedInMph).append(" and a range of ").append(range).append(" is flying. It has a maximum "
				+ "flying time of ").append(range / speedInMph);
	
		
		return builder.toString();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeedInMph() {
		return speedInMph;
	}

	public void setSpeedinMph(double speed) {
		this.speedInMph = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, price, range, speedInMph);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Objects.equals(model, other.model) && price == other.price && range == other.range
				&& Double.doubleToLongBits(speedInMph) == Double.doubleToLongBits(other.speedInMph);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet [model=").append(model).append(", speed=").append(speedInMph).append(", range=").append(range)
				.append(", price=").append(price).append(", getClass()=").append(getClass()).append("]");
		return builder.toString();
	}

}
