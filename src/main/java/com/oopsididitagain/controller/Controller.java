package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;

public abstract class Controller {
	
	public abstract void update(GameState state);
	
	public abstract void handleInput();
}
