package com.oopsididitagain.model;

public class StatCollection {
	//Armory of Entity in order to use it's equipped weapons and armor to calculate some stats
	Armory armory;

	private StatBlob blob;
	
	//derived stats
	private Stat level;
	private Stat lifeCapacity;
	private Stat manaCapacity;
	private Stat offensiveRating;
	private Stat defensiveRating;
	private Stat armorRating;
	
	public StatCollection(Armory armory, StatBlob blob) {
		this.blob = blob;
		deriveStats();
	}
	
	public StatCollection(Armory armory) {
		this.armory = armory;
		this.blob = new StatBlob(0, 0, 0, 0, 0, 0, 0, 0, 0);
		deriveStats();
	}
	
	private void deriveStats() {
		//derived
		level = new Stat(this.blob.getExperience() * .1);
		lifeCapacity = new Stat(0.5 * this.blob.getHardiness());
		manaCapacity = new Stat(25.0 + this.blob.getIntellect() * this.level.getValue());
		offensiveRating = new Stat((blob.getStrength() + armory.getEquippedWeaponRank())* this.level.getValue()); 
		defensiveRating = new Stat(blob.getAgility() * this.level.getValue());
		armorRating = new Stat(blob.getHardiness() * armory.getEquippedArmorRank()); 
	}

	public StatBlob getBlob() {
		return blob;
	}
	
	public void setBlob(StatBlob blob) {
		this.blob = blob;
	}

	public double getLevel() {
		return Math.floor(level.getValue());
	}
	
	public void mergeBlob(StatBlob blob) {
		this.blob.merge(blob);
		
		// has to be handled here because it contains both primary and derived stats
		if(this.blob.getLifeAmount() <= 0) {
			if(this.blob.getLivesLeft() > 0)
				this.blob.getLivesLeftStat().subtract(1);
			this.blob.getLifeAmountStat().setValue(this.blob.getLivesLeft() == 0 ? 0 : lifeCapacity.getValue());
		} else if(this.blob.getLifeAmount() > lifeCapacity.getValue()) {
			this.blob.getLifeAmountStat().setValue(lifeCapacity.getValue());
		}
				
		deriveStats();
	}
	public void detachBlob(StatBlob blob) {
		this.blob.detach(blob);
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

	public double getLifeCapacity() {
		return lifeCapacity.getValue();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append("PRIMARY STATS\n");
		sb.append(blob.toString() + "\n");
		sb.append("DERIVED STATS\n");
		sb.append("Level: " + level + "\n");
		sb.append("Life Capacity: " + lifeCapacity + "\n");
		sb.append("Mana Capacity: " + manaCapacity + "\n");
		sb.append("Offensive Rating: " + offensiveRating + "\n");
		sb.append("Defensive Rating: " + defensiveRating + "\n");
		sb.append("Armor Rating: " + armorRating + "\n");
		return sb.toString();
	}
	
	public String primaryStats() {
		StringBuilder sb = new StringBuilder("");
		sb.append("PRIMARY STATS\n");
		sb.append(blob.toString());
		return sb.toString();
	}
	
	public String derivedStats() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append(	"DERIVED STATS"+
					"\nLevel: " + level.toInt() +
					"\nLife Capacity: " + lifeCapacity.toInt() +
					"\nMana Capacity: " + manaCapacity.toInt() +
					"\nOffensive Rating: " + offensiveRating.toInt() +
					"\nDefensive Rating: " + defensiveRating.toInt() +
					"\nArmor Rating: " + armorRating.toInt());
		
		return sb.toString();
	}
	
	public String primaryViewport() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append(	"PRIMARY STATS"+
					"\nLives Left: "+(int)blob.getLivesLeft()+
					"\nIntellect: "	+(int)blob.getIntellect()+
					"\nStrength: "	+(int)blob.getStrength()+
					"\nAgility: "	+(int)blob.getAgility()+
					"\nHardiness: "	+(int)blob.getExperience()+
					"\nMovement: "	+(int)blob.getMovement()+
					"\nLife: "		+(int)blob.getLifeAmount()+
									"/"+(int)getLifeCapacity()+
					"\nMana: "		+(int)blob.getManaAmount()+
									"/"+(int)getMana());
		
		return sb.toString();
		
	}
	
	public String derivedViewport() {
		StringBuilder sb = new StringBuilder("");
		
		sb.append(	"SECONDARY STATS"+
					"\nLevel: "				+(int)getLevel()+
					"\nOffensive Rating: "	+(int)getOffensiveRating()+
					"\nDefensiveRating: "	+(int)getDefensiveRating()+
					"\nArmor Rating: "		+(int)getArmorRating());
		return sb.toString();
	}

}


