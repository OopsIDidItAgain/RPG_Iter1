package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;

public class PauseGameController extends Controller {

	static PauseGameController instance;
	
	private PauseGameController() {
		
	}
	
	public static Controller getInstance() {
		if ( instance == null ){
			instance = new PauseGameController();
		}
		return instance;
	}
	
	@Override
	public void update(GameState state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleInput() {
		// TODO Auto-generated method stub
		
	}

}
