package com.oopsididitagain.model;
import com.oopsididitagain.gui.InventoryViewport;

public class TakeableItem extends Item {
	
	public TakeableItem(String name, String imageName, Position position) {
		super(name, imageName, position);
	}

	@Override
	public void accept(Entity visitor) {
		visitor.visit(this);	
	}
	

	@Override
	public void accept(InventoryViewport inventoryViewport) {
		inventoryViewport.visit(this);	
	}

	@Override
	public void removeItem(Entity visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toSaveFormat() {
		StringBuilder sb = new StringBuilder(super.toSaveFormat() + ",Takeable");
		return sb.toString();
	}

}
