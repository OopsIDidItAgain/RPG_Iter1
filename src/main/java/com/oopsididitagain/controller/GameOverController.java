package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.controller.states.StartGameState;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.controller.states.PauseGameState;

public class GameOverController extends Controller {

	private static GameOverController instance;
	
	private GameOverController() {
		
	}

	public static Controller getInstance() {
		if ( instance == null ){
			instance = new GameOverController();
		}
		return instance;
	}

	@Override
	public GameState handleInputAndUpdate(GameState state, int input) {
		// TODO handle inputs for play game state
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
				break;
			case KeyCode.EXIT:
				break;
			case KeyCode.ENTER:
				break;
			case KeyCode.EQUIP:
				//returns to the start screen
				state = StartGameState.getInstance();
				break;
			default:
				break;
		}

		return state;
	}
	

}