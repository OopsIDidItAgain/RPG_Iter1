package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.model.Entity;

public class PlayGameController extends Controller{

	private static PlayGameController instance;
	
	private PlayGameController() {
		
	}
	
	public static Controller getInstance() {
		if ( instance == null ){
			instance = new PlayGameController();
		}
		return instance;
	}
	
	@Override
	public void handleInputAndUpdate(GameState state, int input) {
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
				break;
			case KeyCode.USE:
				break;
			case KeyCode.PAUSE:
				state = PauseGameState.getInstance();
				break;
			case KeyCode.EXIT:
				state = ExitGameState.getInstance();
				break;
			default:
				break;
		}
		
	}

}
