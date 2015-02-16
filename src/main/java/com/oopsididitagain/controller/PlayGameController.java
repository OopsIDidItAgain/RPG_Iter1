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
		((PlayGameState)state).terraform_grow();
		//if(((PlayGameState)state).avatarDies() && ((PlayGameState)state).getAvatar().shouldDie())
		//	state = ((PlayGameState)state).changeToGameOverState();
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
				((PlayGameState)state).interact();
				break;
			case KeyCode.PAUSE:
				state = ((PlayGameState)state).changeToPauseState();
				break;
			case KeyCode.EXIT:
				state = ExitGameState.getInstance();
				break;
			case KeyCode.INVENTORY:
				state = InventoryGameState.getInstance();
				break;
			case KeyCode.FLY:
				((PlayGameState)state).toggleFlight();
				break;
			case KeyCode.FARM:
				((PlayGameState)state).terraform();
				break;
			default:
				break;
		}
		state = ((PlayGameState)state).affectAvatar();
		return state;
		
	}

}
