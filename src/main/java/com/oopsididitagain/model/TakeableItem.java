package com.oopsididitagain.model;

import com.oopsididitagain.gui.View;

/* Should this be an interface maybe? Takeable? */
public class TakeableItem extends Item {
	private static final long serialVersionUID = -7151959478242233966L;
	
	public TakeableItem(String name, String imageName, Position position) {
		super(name, imageName, position);
	}

	@Override
	public void accept(Entity visitor) {
		visitor.visit(this);	
	}
	
	
}
