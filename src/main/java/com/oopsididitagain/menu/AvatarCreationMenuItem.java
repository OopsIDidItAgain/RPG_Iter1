package com.oopsididitagain.menu;

public class AvatarCreationMenuItem {
	private String name;
	private int currentValue;
	private int maxValue;
	
	public AvatarCreationMenuItem(String name, int currentValue, int maxValue) {
		super();
		this.name = name;
		this.currentValue = currentValue;
		this.maxValue = maxValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	
	public void increaseValue() {
		if(currentValue < maxValue)
			currentValue++;
	}
	
	public void decreaseValue() {
		if(currentValue > 1)
			currentValue--;
	}
	
	
}
