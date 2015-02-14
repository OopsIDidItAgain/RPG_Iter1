package com.oopsididitagain.controller.states;

import java.util.Collection;
import java.util.HashMap;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.InventoryController;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.menu.InventoryMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Inventory;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.WearableItem;

public class InventoryGameState extends GameState{

	private static InventoryGameState instance;
	private static InventoryMenu inventoryMenu;
	private static Entity avatar;
	private Inventory inventory;
	private GameMap map;
	
	
	private InventoryGameState() {
		// TODO: get menu and pause game things
		GameState state =  PlayGameState.getInstance();
		this.map = ((PlayGameState) state).getGameMap();
		this.avatar = ((PlayGameState) state).getAvatar();
		this.inventory = avatar.getInventory();
		this.inventoryMenu = new InventoryMenu();
	
	}
	
	public InventoryMenu getInventoryMenu() {
		return inventoryMenu;
	}
	
	public GameMap getGameMap() {
		return map;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void changeMenuOption(int keyCode){
		int s = inventory.getSize();
		inventoryMenu.changeMenuOption(keyCode,s);
	};
	
	public int getMenuOption(){
		return inventoryMenu.getSelectedOption();
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new InventoryGameState();
		}
		return instance;
	}
	public String toString(){
		return "InventoryGameState";
	}
	
	public void equip(int option){
		HashMap<String , Item> hash = inventory.getInventory();
		Collection<Item>item = hash.values();
		Object [] inv = item.toArray();
		Item i = (Item)inv[option];
		System.out.println("hi");
		i.accept(avatar);
	}
	
	
	@Override
	public Controller getController() {
		return InventoryController.getInstance();
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}

}
