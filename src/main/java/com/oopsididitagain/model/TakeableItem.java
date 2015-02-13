package com.oopsididitagain.model;

/* Should this be an interface maybe? Takeable? */
public class TakeableItem extends Item {
	private static final long serialVersionUID = -7151959478242233966L;
	
	private boolean isEquippable;
	
	public TakeableItem(boolean equippable) {
		super();
		isEquippable = equippable;
	}
	
	public boolean isEquippable() {
		return isEquippable;
	}
	
}
