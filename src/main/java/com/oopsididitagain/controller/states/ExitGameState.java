package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.gui.View;

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

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}
}
