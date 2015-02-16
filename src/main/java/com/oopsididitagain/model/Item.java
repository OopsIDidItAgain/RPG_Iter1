package com.oopsididitagain.model;

import com.oopsididitagain.controller.states.ItemInteraction;


public abstract class Item extends GameObject implements ItemInteraction {
	
	public Item(String name, String imageName, Position position) {
		super(name, imageName, position);
	}
}