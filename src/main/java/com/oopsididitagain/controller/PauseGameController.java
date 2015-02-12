package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;

public class PauseGameController extends Controller {

	private static PauseGameController instance;
	
	private PauseGameController() {
		
	}
	
	public static Controller getInstance() {
		if ( instance == null ){
			instance = new PauseGameController();
		}
		return instance;
	}

	@Override
	public void handleInputAndUpdate(GameState state, int input) {
		// TODO Auto-generated method stub
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
				// do unpause or do nothing
				// state = PlayGameState.getInstance();
				break;
			case KeyCode.EXIT:
				break;
			default:
				break;
		}
	}
	

}
