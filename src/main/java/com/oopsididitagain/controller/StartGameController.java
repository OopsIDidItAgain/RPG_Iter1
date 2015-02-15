package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.controller.states.StartGameState;
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
		case KeyCode.SOUTH:
		case KeyCode.EAST:
		case KeyCode.WEST:
			((StartGameState)state).changeMenuOption(input);
			break;
		case KeyCode.NORTH_EAST:
		case KeyCode.NORTH_WEST:
		case KeyCode.SOUTH_EAST:
		case KeyCode.SOUTH_WEST:
			break;
		case KeyCode.USE:
			state = ((StartGameState)state).doSelectOption();
			break;
		case KeyCode.PAUSE:
			//state = PauseGameState.getInstance();
			break;
		case KeyCode.EXIT:
			//state = ExitGameState.getInstance();
			break;
		default:
			break;
		}
		return state;
	}

}
