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
	
	public String displayValue(){
		switch(name){
		case("Occupation"):
			switch(currentValue){
			case(1):return" Sneak";
			case(2):return" Summoner";
			case(3):return" Smasher";
			}
		case("Gender"):
			switch(currentValue){
			case(1):return" Female";
			case(2):return" Male";
		}
		case("Hair Color"):
			switch(currentValue){
			case(1):return" Female";
			case(2):return" Male";
		}
		case("Shirt Color"):
			switch(currentValue){
			case(0):return" Female";
			case(1):return" Male";
		}
		default:
			return"";	
	}
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
