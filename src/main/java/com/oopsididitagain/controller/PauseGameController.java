package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.controller.states.PauseGameState;

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
	public GameState handleInputAndUpdate(GameState state, int input) {
		// TODO handle inputs for play game state
		switch(input) {
			case KeyCode.NORTH:
				((PauseGameState)state).changeMenuOption(input);
				break;
			case KeyCode.SOUTH:
				((PauseGameState)state).changeMenuOption(input);
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
				state = PlayGameState.getInstance();
				break;
			case KeyCode.EXIT:
				state = ExitGameState.getInstance();
				break;
			case KeyCode.ENTER:
				break;
			// TODO perform the menu option
			default:
				break;
		}

		return state;
	}
	

}
