package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PauseGameState;

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
				break;
			case KeyCode.SOUTH:
				break;
			case KeyCode.EAST:
				break;
			case KeyCode.WEST:
				break;
			case KeyCode.NORTH_EAST:
				break;
			case KeyCode.NORTH_WEST:
				break;
			case KeyCode.SOUTH_EAST:
				break;
			case KeyCode.SOUTH_WEST:
				break;
			case KeyCode.USE:
				break;
			case KeyCode.PAUSE:
				state = PauseGameState.getInstance();
				break;
			case KeyCode.EXIT:
				break;
			default:
				break;
		}
		
	}

}
