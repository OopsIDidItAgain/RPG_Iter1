package com.oopsididitagain.model;

import com.oopsididitagain.util.Saveable;

public class Armory implements Saveable {
	WearableItem helmet;
	WearableItem weapon;
	WearableItem boots;
	WearableItem armor;
	
	public Armory() {}
	
	public WearableItem getHelmet() { return helmet; }
	public WearableItem getWeapon()	{ return weapon; }
	public WearableItem getBoots() 	{ return boots;  }
	public WearableItem getArmor() 	{ return armor;  }
	
	public WearableItem equip(WearableItem item) {
		WearableItem temp = null;
		switch(item.getType()) {
			case HELMET: {
				temp = helmet;
				helmet = item;
				break;
			}
			case WEAPON: {
				temp = weapon;
				weapon = item;
				break;
			}
			case ARMOR: {
				temp = armor;
				armor = item;
				break;
			}
			case BOOTS: {
				temp = boots;
				boots = item;
				break;
			}
		}
		return temp;
	}
	
	public WearableItem unequip(WearableItem item) {
		if (item == null) return null;
		WearableItem temp = null;
		switch(item.getType()) {
			case HELMET: {
				if (item.equals(helmet)) {
					temp = helmet;
					helmet = null;
				}
				break;
			}
			case WEAPON: {
				if (item.equals(weapon)) {
					temp = weapon;
					weapon = null;
				}
				break;
			}
			case ARMOR: {
				if (item.equals(armor)) {
					temp = armor;
					armor = null;
				}
				break;
			}
			case BOOTS: {
				if (item.equals(boots)) {
					temp = boots;
					boots = null;
				}
				break;
			}
			default: return null;
		}
		return temp;
	}
	
	public int getEquippedWeaponRank() { 
		return (weapon == null) ? 0 : weapon.getRank();
	}

	public int getEquippedArmorRank() { 
		int armorRank = (armor == null) ? 0 : armor.getRank();
		int bootsRank = (boots == null) ? 0 : boots.getRank();
		int helmetRank = (helmet == null) ? 0 : helmet.getRank();
		return armorRank + bootsRank + helmetRank;
	}

	@Override
	public String toSaveFormat() {

		return null;
	}

}
