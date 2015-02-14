package com.oopsididitagain.model;

public class Armory {
	Item helmet;
	Item weapon;
	Item boots;
	Item armor;
	
	public Armory() {}
	
	public Item getHelmet() { return helmet; }
	public Item getWeapon()	{ return weapon; }
	public Item getBoots() 	{ return boots;  }
	public Item getArmor() 	{ return armor;  }
	
	public void equipHelmet(Item helmet) {
		if (helmet.getName().equals("helmet"))
			this.helmet = helmet;
	}
	
	public void equipWeapon(Item weapon) {
		if (weapon.getName().equals("weapon"))
			this.weapon = weapon;
	}
	
	public void equipBoots(Item boots) {
		if (boots.getName().equals("boots"))
			this.boots = boots;
	}
	
	public void equipArmor(Item armor) {
		if (armor.getName().equals("armor"))
			this.armor = armor;
	}
	
	
	public int getEquippedWeapon() { return 0; }
	public int getEquippedArmory() { return 0; }
}
