package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;

public class ExitGameState extends GameState{
	
	private static ExitGameState instance;
	
	private ExitGameState() {
		// TODO: get menu and pause game things
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new ExitGameState();
		}
		return instance;
	}

	@Override
	public Controller getController() {
		// TODO create a exitgamecontroller?
		return null;
	}
}
