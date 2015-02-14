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
	private Inventory inventory;
	private GameMap map;
	
	
	private InventoryGameState() {
		// TODO: get menu and pause game things
		GameState state =  PlayGameState.getInstance();
		this.map = ((PlayGameState) state).getGameMap();
		this.inventory = ((PlayGameState) state).getAvatar().getInventory();
		this.inventoryMenu = new InventoryMenu(inventory.getSize());
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
		inventoryMenu.changeMenuOption(keyCode);
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
	@Override
	public Controller getController() {
		return InventoryController.getInstance();
	}

}
