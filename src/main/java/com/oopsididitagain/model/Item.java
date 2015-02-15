package com.oopsididitagain.model;

import com.oopsididitagain.controller.states.ItemInteraction;


public abstract class Item extends GameObject implements ItemInteraction{
	private static final long serialVersionUID = 4933860466914150600L;	
	
	public Item(String name, String imageName, Position position) {
		super(name, imageName, position);
	}
}