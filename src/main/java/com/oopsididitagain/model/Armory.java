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
	
	public void equipItem(Item item) {
		if (helmet.getName().equals("helmet"))
			this.helmet = helmet;
		else if (helmet.getName().equals("weapons"))
			this.weapon = weapon;
		else if (helmet.getName().equals("boots"))
			this.boots = boots;
		else if (helmet.getName().equals("armor"))
			this.armor = armor;
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
