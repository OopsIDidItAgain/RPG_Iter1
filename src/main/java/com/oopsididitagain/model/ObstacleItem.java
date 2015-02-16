package com.oopsididitagain.model;

import com.oopsididitagain.gui.InventoryViewport;

public class ObstacleItem extends Item {

	public ObstacleItem(String name, String imageName, Position position) {
		super(name, imageName, position);
	}

	@Override
	public void accept(Entity visitor) {
		visitor.visit(this);	
	}

	@Override
	public void accept(InventoryViewport inventoryViewport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeItem(Entity visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toSaveFormat() {
		StringBuilder sb = new StringBuilder(super.toSaveFormat() + ",ObstacleItem");
		return sb.toString();
	}
	

}
