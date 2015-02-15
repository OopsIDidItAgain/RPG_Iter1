package com.oopsididitagain.model;

import com.oopsididitagain.util.WearableItemType;

public class WearableItem extends TakeableItem {


	private static final long serialVersionUID = -8654005789531505596L;
	private int rank;
	private boolean equipped = false;
	private WearableItemType type;
	private StatBlob blob;

	public WearableItem(String name, String imageName, Position position, int rank, 
			StatBlob blob, WearableItemType type) {
		super(name, imageName, position);
		this.rank = rank;
		this.blob = blob;
		this.type = type;
	}

	
	public boolean isEquipped() {
		return equipped;
	}


	public void setEquipped(boolean equipped) {
		this.equipped = equipped;
	}


	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public StatBlob getBlob() {
		return blob;
	}

	public void setBlob(StatBlob blob) {
		this.blob = blob;
	}
	
	public void accept(Entity visitor) {
		visitor.visit(this);	
	}


	public WearableItemType getType() {
		return type;
	}
	
}
