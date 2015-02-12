package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PauseGameController;

public class PauseGameState extends GameState {

	private static PauseGameState instance;
	
	private PauseGameState() {
		// TODO: get menu and pause game things
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new PauseGameState();
		}
		return instance;
	}
	
	
	@Override
	public Controller getController() {
		return PauseGameController.getInstance();
	}

}
