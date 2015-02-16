package com.oopsididitagain.controller.states;

import java.io.File;

import javax.swing.JFileChooser;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PauseGameController;
import com.oopsididitagain.gui.View;
//import com.oopsididitagain.controller.PauseGameState;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.util.CSVTool;

public class PauseGameState extends GameState {

	private static PauseGameState instance;
	private static PauseMenu pauseMenu;
	private Entity avatar;
	private GameMap map;

	private PauseGameState() {
		// TODO: get menu and pause game things
		this.pauseMenu = new PauseMenu();
	}

	public void setAvatar(Entity avatar) {
		 	this.avatar = avatar;
	}

	public void setMap(GameMap map) {
			this.map = map;
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
			saveGame();
			state = PauseGameState.getInstance();
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
	
	private void saveGame() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(null);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File saveGameFile = chooser.getSelectedFile();
			CSVTool.writeSaveGame(map, avatar, saveGameFile);
		}
	}

}
