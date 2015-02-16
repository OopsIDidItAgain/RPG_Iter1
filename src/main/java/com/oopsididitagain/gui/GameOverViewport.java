package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;

import com.oopsididitagain.menu.GameOverMenu;
import com.oopsididitagain.menu.PauseMenu;

public class GameOverViewport extends Viewport {
	private static GameOverMenu gameOverMenu;
	static Graphics gr; 


	public GameOverViewport() {
		super();
	}
	
	
	private static void printView(Graphics g){
		//gr = g;
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.red);
        g2.fill(new RoundRectangle2D.Float(120, 90, 360, 360, 20, 20));
        
        int x = 130, y = 90;
        String[] s = {	"GAME OVER!",	"Press 'j' to exit"	};
        for (int i = 0; i < s.length; i++) 
        	g2.drawString(s[i], x, y += g2.getFontMetrics().getHeight());	 
	}
}
