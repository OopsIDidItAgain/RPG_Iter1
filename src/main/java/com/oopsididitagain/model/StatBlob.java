package com.oopsididitagain.model;

public class StatBlob {
	
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
	
	public double getLivesLeft(){
		return livesLeft.getValue();
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(livesLeft + "\n");
		sb.append(intellect + "\n");
		sb.append(strength + "\n");
		sb.append(agility + "\n");
		sb.append(hardiness + "\n");
		sb.append(experience + "\n");
		sb.append(movement + "\n");
		sb.append(lifeAmount + "\n");
		sb.append(manaAmount + "\n");
		return sb.toString();
	}
}
