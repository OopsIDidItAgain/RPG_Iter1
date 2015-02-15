package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.StartGameController;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.menu.StartMenu;

public class StartGameState extends GameState {

	private static StartGameState instance;
	private StartMenu startMenu;

	private StartGameState() {
		startMenu = new StartMenu();
	}

	public static GameState getInstance() {
		if (instance == null) {
			instance = new StartGameState();
		}
		return instance;
	}

	public StartMenu getStartMenu() {
		return startMenu;
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}

	@Override
	public Controller getController() {
		return StartGameController.getInstance();
	}

	public void changeMenuOption(int input) {
		startMenu.changeMenuOption(input);
	}

	public GameState doSelectOption() {
		return startMenu.doSelectOption();
	}
}
