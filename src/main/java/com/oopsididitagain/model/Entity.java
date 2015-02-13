package com.oopsididitagain.model;

import java.util.HashMap;

import com.oopsididitagain.io.KeyCode;

public class Entity extends GameObject {
	private static final long serialVersionUID = 6897867058695115274L;
    private Inventory inventory;
    
    public Entity() {
    	inventory = new Inventory();
    }
    
	public void move(int keyCode) {

		//switch(keyCode) {
		//	case KeyCode.NORTH:
		//}
	}
	
	public void populateInventory() {
		inventory.addItem(new Sword());
		inventory.addItem(new Cape());
		inventory.addItem(new Potion());
		// System.out.println("Populate ran");
	}
	
	public void printInventory() {
	    HashMap<String , Item> hash = inventory.getInventory();
		
		for (String name: hash.keySet())
            System.out.println(name);
	}
}
