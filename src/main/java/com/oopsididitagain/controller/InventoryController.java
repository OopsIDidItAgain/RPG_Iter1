package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.InventoryGameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.io.KeyCode;

public class InventoryController extends Controller{
	private static InventoryController instance;
	
	private InventoryController() {
		
	}

	public static Controller getInstance() {
		if ( instance == null ){
			instance = new InventoryController();
		}
		return instance;
	}

	@Override
	public GameState handleInputAndUpdate(GameState state, int input) {
				switch(input) {
					case KeyCode.NORTH:
					case KeyCode.SOUTH:
					case KeyCode.EAST:
					case KeyCode.WEST:
						((InventoryGameState)state).changeMenuOption(input);
						break;
					case KeyCode.NORTH_EAST:
						break;
					case KeyCode.NORTH_WEST:
						break;
					case KeyCode.SOUTH_EAST:
						break;
					case KeyCode.SOUTH_WEST:
						break;
					case KeyCode.PAUSE:
						break;
					case KeyCode.EXIT:
						break;
					case KeyCode.INVENTORY:
						state = PlayGameState.getInstance();
						break;
					case KeyCode.USE:
					case KeyCode.EQUIP:
						int option = ((InventoryGameState)state).getMenuOption();
						((InventoryGameState)state).equip(option);
						break;
					case KeyCode.DROP:
						int dropOption = ((InventoryGameState)state).getMenuOption();
						((InventoryGameState)state).drop(dropOption);
						break;
					default:
						break;
				}
				return state;
				
			}
	}
