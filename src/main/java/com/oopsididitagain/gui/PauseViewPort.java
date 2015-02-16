package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.oopsididitagain.menu.PauseMenu;

public class PauseViewPort extends Viewport {	

private static PauseMenu pauseMenu;

public PauseViewPort(PauseMenu pauseMenu) {
	super();
	this.pauseMenu = pauseMenu;
}

public static void displayPauseMenu(Graphics g){
	int option = pauseMenu.getSelectedOption();
	 Graphics2D g2 = (Graphics2D) g;
	 g2.setPaint(Color.black);
	 g2.fill(new Rectangle2D.Double(200, 200, 200, 200));
	 g2.setPaint(Color.white);
	 String save = "save";
	 String exit = "exit";
	 String unpause = "unpause";
	 
	switch(option){
	case 1:
		save = "> "+ save;
		break;
	case 2:
		exit = ">" + exit;
		break;
	case 3:
		unpause = ">" + unpause;
		break;

	}
	g2.drawString(save, 300, 250);
	g2.drawString(exit, 300, 300);
	g2.drawString(unpause, 300, 350);
	
}


}
