package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.InventoryGameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.model.Entity;

public class PlayGameController extends Controller{

	private static PlayGameController instance;
	//private Entity avatar;
	
	
	
	public PlayGameController() {
		super();
		//this.avatar = avatar;
	}

	public static Controller getInstance() {
		if ( instance == null ){
			instance = new PlayGameController();
		}
		return instance;
	}
	
	@Override
	public GameState handleInputAndUpdate(GameState state, int input) {
		// TODO: send messages to avatar
		switch(input) {
			case KeyCode.NORTH:
			case KeyCode.SOUTH:
			case KeyCode.EAST:
			case KeyCode.WEST:
			case KeyCode.NORTH_EAST:
			case KeyCode.NORTH_WEST:
			case KeyCode.SOUTH_EAST:
			case KeyCode.SOUTH_WEST:
				((PlayGameState)state).moveAvatar(input);
				break;
			case KeyCode.USE:
				break;
			case KeyCode.PAUSE:
				state = PauseGameState.getInstance();
				break;
			case KeyCode.EXIT:
				state = ExitGameState.getInstance();
				break;
			case KeyCode.INVENTORY:
				state = InventoryGameState.getInstance();
				break;
			default:
				break;
		}
		return state;
		
	}

}
