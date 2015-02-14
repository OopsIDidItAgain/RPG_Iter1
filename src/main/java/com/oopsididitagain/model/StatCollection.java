package com.oopsididitagain.model;

public class StatCollection {
	//Armory of Entity in order to use it's equipped weapons and armor to calculate some stats
	//Armory armory;

	private StatBlob blob;
	
	//derived stats
	private Stat level;
	private Stat lifeCapacity;
	private Stat manaCapacity;
	private Stat offensiveRating;
	private Stat defensiveRating;
	private Stat armorRating;
	
	public StatCollection(/*Armory armory, */StatBlob blob) {
		//primary
		this.blob = blob;
		deriveStats();
	}
	
	public StatCollection(/*Armory armory*/) {
		//this.armory = armory;
		this.blob = new StatBlob(0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	private void deriveStats() {
		//derived
		level = new Stat(this.blob.getExperience() * .1);
		lifeCapacity = new Stat(.01 * this.blob.getHardiness());
		manaCapacity = new Stat(25.0 + this.blob.getIntellect() * this.level.getValue());
		offensiveRating = new Stat((blob.getStrength() * this.level.getValue())); // we need to account for offensive rating
		defensiveRating = new Stat(blob.getAgility() * this.level.getValue());
		armorRating = new Stat(blob.getHardiness()); // we need to account for armor rating
	}

	public double getLevel() {
		return level.getValue();
	}
	
	public void mergeBlob(StatBlob blob) {
		this.blob.merge(blob);
		deriveStats();
	}

	public double getMana() {
		return manaCapacity.getValue();
	}
	
	public double getOffensiveRating() {
		return offensiveRating.getValue();
	}

	public double getDefensiveRating() {
		return defensiveRating.getValue();
	}

	public double getArmorRating() {
		return armorRating.getValue();
	}

	public double getLifeCapactiy() {
		return lifeCapacity.getValue();
	}
	
	@Override
	public String toString() {
		return blob.toString();
	}

}


