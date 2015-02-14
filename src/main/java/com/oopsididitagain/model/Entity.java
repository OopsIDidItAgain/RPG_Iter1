package com.oopsididitagain.model;

import java.util.HashMap;

public class Entity extends GameObject {
	private static final long serialVersionUID = 6897867058695115274L;
    private Inventory inventory;
    private Armory armory;
    
    public Entity(String name, String imageName, Position position) {
    	super (name, imageName, position);
    	inventory = new Inventory();
    	armory = new Armory();
    }
    
	public void addToInventory(TakeableItem takeableItem) {
		this.inventory.addItem(takeableItem);
		printInventory();
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void printInventory() {
	    HashMap<String , Item> hash = inventory.getInventory();
		
	    System.out.println("Inventory Contents:");
		for (String name: hash.keySet())
            System.out.println(name);
	}
}
