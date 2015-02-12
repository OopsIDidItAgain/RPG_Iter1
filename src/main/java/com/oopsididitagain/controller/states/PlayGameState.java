package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PlayGameController;

public class PlayGameState extends GameState {

	private static PlayGameState instance;
	
	private PlayGameState() {
		// TODO: get model game things
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new PlayGameState();
		}
		return instance;
	}
	
	@Override
	public Controller getController() {
		return PlayGameController.getInstance();
	}

}
