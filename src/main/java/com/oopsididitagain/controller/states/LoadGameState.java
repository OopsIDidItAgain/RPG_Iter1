package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.gui.View;

public class LoadGameState extends GameState {

	private static LoadGameState instance;

	private LoadGameState() {
		// TODO: get menu and pause game things
	}

	public static GameState getInstance() {
		if (instance == null) {
			instance = new LoadGameState();
		}
		return instance;
	}

	@Override
	public void accept(View visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return null;
	}

}
