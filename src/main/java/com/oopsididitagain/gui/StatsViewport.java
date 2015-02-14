package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class StatsViewport extends Viewport{
	
	public StatsViewport() {
		super();
	
	}
	public void displayStats(Graphics g){
		 Graphics2D g2 = (Graphics2D) g;
		 g2.setPaint(Color.red);
		 g2.fill(new Rectangle2D.Double(0,540, 600, 160));

	}
	
	
	
}

