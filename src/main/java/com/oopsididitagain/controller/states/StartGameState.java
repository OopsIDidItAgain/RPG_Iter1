package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.StartGameController;

public class StartGameState extends GameState {

	private static StartGameState instance;
	
	private StartGameState() {
		// TODO: get model game things
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new StartGameState();
		}
		return instance;
	}
	
	@Override
	public Controller getController() {
		return StartGameController.getInstance();
	}
}
