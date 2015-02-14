package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

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
		 g2.setPaint(Color.black);
		 g2.fill(new Rectangle2D.Double(0,540, 600, 160));
		 
		 // statsBox
		 g2.setPaint(Color.yellow);
		 g2.fill(new Rectangle2D.Double(0, 540, 138, 160));
		 
		 // experienceBar
		 g2.setPaint(Color.CYAN);
		 g2.fill(new Ellipse2D.Double(220,540,138,138));
		 
		 // our guy's face bar
		 g2.setPaint(Color.MAGENTA);
		 g2.fill(new Rectangle2D.Double(450,540,160,150));
		 		 
		 
		 String stats = avatar.getStats().toString();
		 int x = 10, y = 537; // location of text
		 
		 g2.setPaint(Color.black);
		 g2.setFont(new Font("Default", Font.BOLD, 12));
		 for (String line : stats.split("\n")) {
		        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
		        // graphics2d doesn't handle "\n" as new lines, so we have to split it
				
		        /*if (y > 610) { // new line
		        	x = 145;
		        	y = 540;
		        }*/
		 }
		 
		 
	}
	
	
	
}

