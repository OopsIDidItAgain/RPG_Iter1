package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import com.oopsididitagain.menu.PauseMenu;

public class PauseViewPort extends Viewport {	

private static PauseMenu pauseMenu;

public PauseViewPort(PauseMenu pauseMenu) {
	super();
	this.pauseMenu = pauseMenu;
}

public static void displayPauseMenu(Graphics g){
	int option = pauseMenu.getSelectedOption();
	switch(option){
	case 1:
		g.drawRect(0, 300, 10, 10);
		break;
	case 2:
		g.drawRect(200, 300, 10, 10);
		break;
	case 3:
		g.drawRect(400, 300, 10, 10);
		break;
	case 5:
		g.drawRect(400, 300, 100, 100);
	}
	
}


}
