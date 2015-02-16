package com.oopsididitagain.model;

import com.oopsididitagain.gui.InventoryViewport;

public class OneShotItem extends Item {
	private static final long serialVersionUID = -8577184907159245197L;

	StatBlob blob;

	public OneShotItem(String name, String imageName, Position position, StatBlob blob) {
		super(name, imageName, position);
		this.blob = blob;
	}

	@Override
	public void accept(Entity visitor) {
		visitor.visit(this);
	}

	@Override
	public void accept(InventoryViewport inventoryViewport) {

	}

	public StatBlob getBlob() {
			return blob;
	}

	@Override
	public void removeItem(Entity visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toSaveFormat() {
		StringBuilder sb = new StringBuilder(super.toSaveFormat() + ",OneShotItem");
		sb.append("," + blob.toSaveFormat());
		return sb.toString();
	}
}
