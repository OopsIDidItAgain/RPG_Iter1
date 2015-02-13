package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;

public abstract class Controller {
	
	public abstract GameState handleInputAndUpdate(GameState state, int input);
	
}
