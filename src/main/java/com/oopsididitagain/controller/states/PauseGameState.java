package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PauseGameController;
import com.oopsididitagain.gui.View;
//import com.oopsididitagain.controller.PauseGameState;
import com.oopsididitagain.menu.PauseMenu;

public class PauseGameState extends GameState {

	private static PauseGameState instance;
	private static PauseMenu pauseMenu;
	
	private PauseGameState() {
		// TODO: get menu and pause game things
		this.pauseMenu = new PauseMenu();
	}
	
	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}

	public void changeMenuOption(int keyCode){
		pauseMenu.changeMenuOption(keyCode);
	};
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new PauseGameState();
		}
		return instance;
	}
	public String toString(){
		return "PauseGameState";
	}
	@Override
	public Controller getController() {
		return PauseGameController.getInstance();
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}

}
