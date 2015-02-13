package com.oopsididitagain.model;


public abstract class Item extends GameObject {
	private static final long serialVersionUID = 4933860466914150600L;
	
	public Item(String name, String imageName, Position position) {
		super(name, imageName, position);
	}
}