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

	public abstract void fly();

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
		builder.append(getClass().getSimpleName()).append(" [Model: ").append(model).append(", Speed in MPH: ").append(speedInMph).append(", Range: ").append(range)
				.append(", Price: ").append(price).append("]");
		return builder.toString();
	}

}
