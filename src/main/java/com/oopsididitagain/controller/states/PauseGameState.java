package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PauseGameController;

public class PauseGameState extends GameState {

	@Override
	public Controller getController() {
		return PauseGameController.getInstance();
	}

}
