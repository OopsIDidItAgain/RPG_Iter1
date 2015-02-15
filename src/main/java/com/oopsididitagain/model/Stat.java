package com.oopsididitagain.model;

public class Stat {
	// TODO: Add logic to cap @ 100 some things..
	private double value;
	
	public Stat(double value)  {
		this.value = value;
	}
	
	public void add(Stat other) {
		value += other.getValue();
	}
	
	public void subtract(Stat other) {
		value -= other.getValue();
	}
	
	public double getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}
	
	public int toInt() { return (int)value; }
	
}
