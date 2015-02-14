package com.oopsididitagain.model;

import java.util.HashMap;

public class Entity extends GameObject {
	private static final long serialVersionUID = 6897867058695115274L;
    private Inventory inventory;
    private StatCollection stats;
    
    public Entity(String name, String imageName, Position position) {
    	super (name, imageName, position);
    	stats = new StatCollection();
    	inventory = new Inventory();
    }
    
	public void addToInventory(TakeableItem takeableItem) {
		this.inventory.addItem(takeableItem);
		if (takeableItem instanceof WearableItem) {
			equip((WearableItem)takeableItem);
		}
		printInventory();
	}
	
	public void equip(WearableItem item) {
		stats.mergeBlob(item.getBlob());
		System.out.println(stats);
	}
	
	public void printInventory() {
	    HashMap<String , Item> hash = inventory.getInventory();
		
	    System.out.println("Inventory Contents:");
		for (String name: hash.keySet())
            System.out.println(name);
	}
}
