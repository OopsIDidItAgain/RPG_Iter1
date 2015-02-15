package com.oopsididitagain.gui;

import java.awt.Graphics;

import com.oopsididitagain.menu.StartMenu;

public class StartGameViewport {

	private StartMenu startMenu;

	public StartGameViewport(StartMenu startMenu) {
		this.startMenu = startMenu;
	}


	public void displayStartMenu(Graphics g) {
		int selectedOption = startMenu.getSelectedOption();

		String newgame = "New Game";
		String loadgame = "Load Game";
		String exitgame = "ExitGame";
		
		switch (selectedOption) {
		case StartMenu.NEW_GAME:
			newgame = "> "+newgame+" <";
			break;
		case StartMenu.LOAD_GAME:
			loadgame = "> "+loadgame+" <";
			break;
		case StartMenu.EXIT_GAME:
			exitgame = "> "+exitgame+" <";
			break;
		default:
			break;
		}

		g.drawString(newgame, 100, 250);
		g.drawString(loadgame, 100, 300);
		g.drawString(exitgame, 100, 350);
	}

}
