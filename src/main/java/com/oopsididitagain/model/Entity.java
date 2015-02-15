package com.oopsididitagain.model;

import java.util.HashMap;

public class Entity extends GameObject {
	private static final long serialVersionUID = 6897867058695115274L;
    private Inventory inventory;
    private Occupation occupation;

    private Armory armory;
    private StatCollection stats;

    public Entity(String name, String imageName, Position position) {
    	super (name, imageName, position);
    	stats = new StatCollection();
    	inventory = new Inventory();
    	armory = new Armory();
    }
    
    public Entity(String name, String imageName, Position position, Occupation occupation) {
    	this(name, imageName, position);
    	changeOccupation(occupation);
    }
    
	public void addToInventory(TakeableItem takeableItem) {
		this.inventory.addItem(takeableItem);
		printInventory();
	}
	

	public Inventory getInventory() {
		return inventory;
	}
	
	public void equip(WearableItem item) {
		stats.mergeBlob(item.getBlob());
		item.setEquipped(true);
		System.out.println(stats);

	}
	public void unequip(WearableItem item) {
		stats.detachBlob(item.getBlob());
		item.setEquipped(false);
		System.out.println(stats);
	}
	
	public StatCollection getStats() {
		return stats;
	}

	public void printInventory() {
	    HashMap<String , Item> hash = inventory.getInventory();
		
	    System.out.println("Inventory Contents:");
		for (String name: hash.keySet())
            System.out.println(name);
	}
	public void visit(WearableItem wearableItem){
		if(wearableItem.isEquipped()){
			this.unequip(wearableItem);
			}else{
			this.equip(wearableItem);
		}
	}
	public void visit(TakeableItem takeableitem){
		System.out.println("takeable");
	}

	public void visit(ObstacleItem obstacleItem) {
		// TODO Auto-generated method stub
		
	}
	
	public void changeOccupation(Occupation occupation) {
		if (this.occupation != null) 
			this.stats.detachBlob(this.occupation.getStats());

		this.stats.mergeBlob(occupation.getStats());
		this.occupation = occupation;
	}
	
}

