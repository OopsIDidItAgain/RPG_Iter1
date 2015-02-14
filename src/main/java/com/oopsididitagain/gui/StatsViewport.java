package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class StatsViewport extends Viewport{
	Entity avatar;
	
	public StatsViewport() {
		super();
	}
	
	public StatsViewport(Entity avatar) {
		super();
		this.avatar = avatar;
	}
	
	public void displayStats(Graphics g){
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setPaint(Color.red);
		 g2.fill(new Rectangle2D.Double(0,540, 600, 160));

		 g2.setPaint(Color.black);
		 
		 // graphics2d doesn't handle \n as new lines
		 // we have to split it
		 
		 String stats = avatar.getStats().toString();
		 int x = 25, y = 540; // location of text
		 for (String line : stats.split("\n")) {
		        g.drawString(line, x, y += g.getFontMetrics().getHeight());
		        if (y > 610) { // go to new line
		        	x = 150;
		        	y = 540;
		        }
		 }
		 
		 
	}
	
	
	
}

