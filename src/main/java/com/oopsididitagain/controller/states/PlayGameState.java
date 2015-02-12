package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PlayGameController;

public class PlayGameState extends GameState {

	@Override
	public Controller getController() {
		return PlayGameController.getInstance();
	}

}
