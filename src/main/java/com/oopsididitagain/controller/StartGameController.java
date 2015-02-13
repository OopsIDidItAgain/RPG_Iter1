package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.io.KeyCode;

public class StartGameController extends Controller {

	private static StartGameController instance;

	private StartGameController() {

	}

	public static Controller getInstance() {
		if (instance == null) {
			instance = new StartGameController();
		}
		return instance;
	}

	@Override
	public GameState handleInputAndUpdate(GameState state, int input) {
		// TODO handle start game inputs
		switch (input) {
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
			state = ExitGameState.getInstance();
			break;
		default:
			break;
		}
		return state;
	}

}
