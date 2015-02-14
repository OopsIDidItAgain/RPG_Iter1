package com.oopsididitagain.model;

public class WearableItem extends TakeableItem {


	private static final long serialVersionUID = -8654005789531505596L;
	private int rank;
	private StatBlob blob;

	public WearableItem(String name, String imageName, Position position, int rank, StatBlob blob) {
		super(name, imageName, position);
		this.rank = rank;
		this.blob = blob;
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
	
}
