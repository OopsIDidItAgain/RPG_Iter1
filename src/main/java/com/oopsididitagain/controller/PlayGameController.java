package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;

public class PlayGameController extends Controller {

	static PlayGameController instance;
	
	private PlayGameController() {
		
	}
	
	public static Controller getInstance() {
		if ( instance == null ){
			instance = new PlayGameController();
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
