package com.oopsididitagain.model;

public class Stats {
	//Armory of Entity in order to use it's equipped weapons and armor to calculate some stats
	Armory armory;
	
	//primary stats
	private int livesLeft;
	private int strength;
	private int agility;
	private int intellect;
	private int hardiness;
	private int experience;
	private int movement;
	
	//derived stats
	private int life;
	private int mana;
	private int offensiveRating;
	private int defensiveRating;
	private int armorRating;
	
	public Stats(Armory armory,int livesLeft, int strength, int agility, int intellect, int hardiness, int experience, int movement){
		
		this.armory = armory;
		
		//primary
		this.livesLeft = livesLeft;
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.hardiness = hardiness;
		this.experience = experience;
		this.movement = movement;
		
		//derived
		life = 100 + (hardiness * getLevel());
		mana = 25 +  (intellect * getLevel());
		offensiveRating = armory.getEquippedWeapon() + (strength * getLevel());
		defensiveRating = agility * getLevel();
		armorRating = armory.getEquippedArmory() + hardiness;
		
	}
	//derived stat getters
	
	public int getLevel(){
		
		return experience / 10;
	}
	public int getLife(){
		
		return life;
	}
	public int getMana(){
		
		return mana;
		
	}
	public int getOffensiveRating(){
		
		return offensiveRating;
	}
	public int getDefensiveRating(){
		
		return defensiveRating;
		
	}
	public int getArmorRating(){
		
		return armorRating;
	}
	
	//primary stat getters/setters
	public int getLivesLeft() {
		return livesLeft;
	}

	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getHardiness() {
		return hardiness;
	}

	public void setHardiness(int hardiness) {
		this.hardiness = hardiness;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}
	
	
	
}
