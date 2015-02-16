package com.oopsididitagain.model;

import java.util.HashMap;

import com.oopsididitagain.util.Saveable;

/** Inventory
 *
 * Created by parango on 2/12/15.
 */
public class Inventory implements Saveable {
    private HashMap<String , Item> inventory;

    public Inventory() {
        inventory = new HashMap<>();
    }

    public HashMap<String, Item> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Item> inventory) {
        this.inventory = inventory;
    }

    public void addItem(Item item){
        this.inventory.put(item.getName(), item);
    }

    public Item getItem(String itemName){
        return inventory.get(itemName);
    }

    public void deleteItem(String itemName) {
    	inventory.remove(itemName);
    }

	public int getSize() {
		return inventory.size();
	}

	@Override
	public String toSaveFormat() {
		// TODO Auto-generated method stub
		return null;
	}
	


    
}
