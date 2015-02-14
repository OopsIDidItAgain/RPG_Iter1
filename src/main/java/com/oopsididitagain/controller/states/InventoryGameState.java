package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.InventoryController;
import com.oopsididitagain.menu.InventoryMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Inventory;

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
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new InventoryGameState();
		}
		return instance;
	}
	public String toString(){
		return "InventoryGameState";
	}
	/*
	public void unequip(Item i){
		avatar.getStats().mergeBlob(item.getBlob());
		System.out.println(stats);
	}
	*/
	
	@Override
	public Controller getController() {
		return InventoryController.getInstance();
	}

}
