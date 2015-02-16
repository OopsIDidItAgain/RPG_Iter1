package com.oopsididitagain.controller.states;



import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
			File file = chooseFile();
			GameMap m = CSVTool.makeLoadedMap(file);
			Entity avatar = CSVTool.makeLoadedAvatar(file);
			System.out.println(file.getAbsolutePath());
			
			//state = PlayGameState.getInstance();
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
	
	private File chooseFile() {
		File loadGameFile = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files", "csv");
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
			loadGameFile = chooser.getSelectedFile();
		return loadGameFile;
	}
}
