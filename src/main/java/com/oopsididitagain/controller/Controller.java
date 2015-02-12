package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;

public abstract class Controller {
	
	public abstract void handleInputAndUpdate(GameState state, int input);
	
}
