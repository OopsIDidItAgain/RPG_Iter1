package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PauseGameController;
import com.oopsididitagain.gui.View;
//import com.oopsididitagain.controller.PauseGameState;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class PauseGameState extends GameState {

	private static PauseGameState instance;
	private static PauseMenu pauseMenu;
	private static Entity avatar;
	private static GameMap map;

	private PauseGameState() {
		// TODO: get menu and pause game things
		this.pauseMenu = new PauseMenu();
	}

	public static void setAvatar(Entity av) {
		 	avatar = av;
	}

	public static void setMap(GameMap m) {
		map = m;
	}

	public PauseMenu getPauseMenu() {
		return pauseMenu;
	}

	public void changeMenuOption(int keyCode) {
		pauseMenu.changeMenuOption(keyCode);
	};

	public static GameState getInstance() {
		if (instance == null) {
			instance = new PauseGameState();
		}
		return instance;
	}

	public String toString() {
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

	public GameState doMenuOption() {
		int option = pauseMenu.getSelectedOption();
		GameState state;
		switch (option) {
		case (1):// saveStuffz!

			state = ExitGameState.getInstance();
			return state;
		case (2):// exit
			state = ExitGameState.getInstance();
			return state;
		case (3):
			state = PlayGameState.getInstance();
			return state;
		default:
			state = PauseGameState.getInstance();
			return state;
		}

	}

}
