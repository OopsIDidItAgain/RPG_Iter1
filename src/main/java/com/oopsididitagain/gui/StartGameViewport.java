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

		switch (selectedOption) {
		case StartMenu.NEW_GAME:
			g.drawString("> New Game <", 100, 250);
			g.drawString("  Load Game", 100, 300);
			g.drawString("  Exit Game", 100, 350);
			break;
		case StartMenu.LOAD_GAME:
			g.drawString("  New Game", 100, 250);
			g.drawString("> Load Game <", 100, 300);
			g.drawString("  Exit Game", 100, 350);
			break;
		case StartMenu.EXIT_GAME:
			g.drawString("  New Game", 100, 250);
			g.drawString("  Load Game", 100, 300);
			g.drawString("> Exit Game <", 100, 350);
			break;
		default:
			break;
		}
	}

}
