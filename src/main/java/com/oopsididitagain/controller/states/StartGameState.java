package com.oopsididitagain.controller.states;



import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.StartGameController;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.menu.StartMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.util.CSVTool;

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

	public String toString(){
		return "StartGameState";
	}
	
	public void changeMenuOption(int input) {
		startMenu.changeMenuOption(input);
	}

	public GameState doSelectOption() {
		GameState state = this;
		int selectedOption = startMenu.getSelectedOption();
		switch(selectedOption) {
		case StartMenu.NEW_GAME:
			state = AvatarCreationGameState.getInstance();
			break;
		case StartMenu.LOAD_GAME:
			GameMap m = CSVTool.makeLoadedMap();
			Entity avatar = CSVTool.makeLoadedAvatar();
			
			state = PlayGameState.getInstance();
			((PlayGameState)state).setMap(m);
			((PlayGameState)state).setAvatar(avatar);
			break;
		case StartMenu.EXIT_GAME:
			state = ExitGameState.getInstance();
			break;
		default:
			break;
		}
		return state;
	}
}
