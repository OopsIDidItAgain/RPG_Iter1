package com.oopsididitagain.model;

import java.awt.Image;

/* Should this be an interface maybe? Takeable? */
public class TakeableItem extends Item {
	private static final long serialVersionUID = -7151959478242233966L;
	
	private boolean isEquippable;
	
	public TakeableItem(String name, boolean equippable, Image image) {
		super(name);
		isEquippable = equippable;
		this.image = image;
	}
	
	public boolean isEquippable() {
		return isEquippable;
	}	
}