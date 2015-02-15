package com.oopsididitagain.model;

public class StatBlob {
	
	public final static StatBlob SNEAK_DEFAULT = new StatBlob(3, 10, 50, 20, 20, 0, 50, 100, 100);
	public final static StatBlob SMASHER_DEFAULT = new StatBlob(3, 50, 20, 10, 40, 0, 25, 100, 100);
	public final static StatBlob SUMMONER_DEFAULT = new StatBlob(3, 15, 20, 50, 10, 0, 25, 100, 100);
	
	//primary stats
	private Stat livesLeft;
	private Stat intellect;
	private Stat strength;
	private Stat agility;
	private Stat hardiness;
	private Stat experience;
	private Stat movement;
	private Stat lifeAmount;
	private Stat manaAmount;
	
	public StatBlob(double livesLeft, double strength, double agility, 
			double intellect, double hardiness, double experience, double movement,
			double lifeAmount, double manaAmount) {
		this.livesLeft = new Stat(livesLeft);
		this.strength = new Stat(strength);
		this.agility = new Stat(agility);
		this.intellect = new Stat(intellect);
		this.hardiness = new Stat(hardiness);
		this.experience = new Stat(experience);
		this.movement = new Stat(movement);
		this.lifeAmount = new Stat(lifeAmount);
		this.manaAmount = new Stat(manaAmount);
	}
	
	public int getLivesLeft(){
		return (int)livesLeft.getValue();
	}

	public double getIntellect(){
		return intellect.getValue();
	}

	public double getStrength(){
		return strength.getValue();
	}

	public double getAgility(){
		return agility.getValue();
	}

	public double getHardiness(){
		return hardiness.getValue();
	}

	public double getExperience(){
		return experience.getValue();
	}
	
	public double getMovement() {
		return movement.getValue();
	}

	public double getManaAmount() {
		return manaAmount.getValue();
	}

	public double getLifeAmount() {
		return lifeAmount.getValue();
	}
	
	public void merge(StatBlob other) {
		this.livesLeft.add(other.livesLeft);
		this.intellect.add(other.intellect);
		this.strength.add(other.strength);
		this.agility.add(other.agility);
		this.hardiness.add(other.hardiness);
		this.experience.add(other.experience);
		this.movement.add(other.movement);
		this.lifeAmount.add(other.lifeAmount);
		this.manaAmount.add(other.manaAmount);
	}
	
	public void detach(StatBlob other) {
		this.livesLeft.subtract(other.livesLeft);
		this.intellect.subtract(other.intellect);
		this.strength.subtract(other.strength);
		this.agility.subtract(other.agility);
		this.hardiness.subtract(other.hardiness);
		this.experience.subtract(other.experience);
		this.movement.subtract(other.movement);
		this.lifeAmount.subtract(other.lifeAmount);
		this.manaAmount.subtract(other.manaAmount);
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(	"Intellect: " + intellect.toInt() +
					"\nStrength: " + strength.toInt() +
					"\nAgility: " + agility.toInt() +
					"\nHardiness: " + hardiness.toInt() +
					"\nExperience: " + experience.toInt() +
					"\nMovement: " + movement.toInt() + 
					"\nLife Amount: " + lifeAmount.toInt() +
					"\nMana Amount: " + manaAmount.toInt());
		return sb.toString();
	}
}