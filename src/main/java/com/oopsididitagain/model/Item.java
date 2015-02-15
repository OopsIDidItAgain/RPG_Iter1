package com.oopsididitagain.model;

import java.awt.Image;

public abstract class Item extends GameObject {
	private static final long serialVersionUID = 4933860466914150600L;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, Image image) {
		this.name = name;
		this.image = image;
	}
	
	public Item(String name, Image image, Position position) {
		this.name = name;
		this.image = image;
		this.position = position;
	}
}