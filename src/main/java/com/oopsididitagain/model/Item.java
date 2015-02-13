package com.oopsididitagain.model;


public abstract class Item extends GameObject {
	private static final long serialVersionUID = 4933860466914150600L;
	
	private String name;
	
	public Item(String name) {
		this.name = name;
	}
}