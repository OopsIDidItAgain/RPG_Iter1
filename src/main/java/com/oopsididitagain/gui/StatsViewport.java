package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class StatsViewport extends Viewport{
	Entity avatar;
	Image happyface;
	Image sadface;
	
	public StatsViewport() {
		super();
	}
	
	public StatsViewport(Entity avatar) {
		super();
		this.avatar	= avatar;
		happyface 	= Toolkit.getDefaultToolkit().createImage(getClass().getResource("/happy_face.png"));
		sadface 	= Toolkit.getDefaultToolkit().createImage(getClass().getResource("/dead_face.png"));
	}
	
	public void displayStats(Graphics g){
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setPaint(Color.black);
		 g2.fill(new Rectangle2D.Double(0,540, 600, 160));
		 
		 // primaryStatsBox
		 g2.setPaint(new Color(0x3498db));
		 g2.fill(new Rectangle2D.Double(0, 540, 130, 160));
		 
		 // derivedStatsBox
		 g2.setPaint(new Color(0xf1c40f));
		 g2.fill(new Rectangle2D.Double(130,540,150,160));
		 
		 // our guy's face bar
		 if (avatar.getStats().getBlob().getLivesLeft() != 0)
			g2.drawImage(happyface, 450, 540, 150, 140, null);
		 else
			g2.drawImage(sadface, 450,540,150,140, null);

		 
		 // actually printing out primary and derived stats
		 // String pStats = avatar.getStats().primaryStats();
		 // String dStats = avatar.getStats().derivedStats();

		 String pStats = avatar.getStats().primaryViewport();
		 String dStats = avatar.getStats().derivedViewport();

		 int x = 10, y = 537; // location of text
		 
		 g2.setPaint(Color.black);
		 g2.setFont(new Font("Default", Font.BOLD, 11));
		 for (String line : pStats.split("\n"))
		        g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
		        // graphics2d doesn't handle "\n" as new lines, so we have to split it
		 
		 x+=130; y = 537;
		 for (String line : dStats.split("\n"))
			 g2.drawString(line, x, y+= g2.getFontMetrics().getHeight());
		 
		 
	}
	
	
	
}

