package com.oopsididitagain.gui;

<<<<<<< HEAD
public class StatsViewport extends Viewport {
	private static final long serialVersionUID = -4960198915890489235L;
	// Stats stats; // this doesn't exist in code yet
	
	public StatsViewport() {
		super();
		setFocusable(true);
	}
	
	/* 		// these all incorporate a "Stats" object,
			// which doesn't exist in code yet
			 
	public StatsViewport(Stats stats) {
		this.stats = stats;
		
		super();
		setFocusable(true);
	}	
	
	
	public Stats getStats() {
		return stats;
=======
import java.awt.Color;
import java.awt.Dimension;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class StatsViewport extends Viewport{
	
	public StatsViewport() {
		super();
		this.setBackground(new Color(0,100,0));
		this.setPreferredSize(new Dimension(600, 160));
	}
	
	public void render(){
		repaint();
>>>>>>> 6a77571b196635bb33e26ca0dcd2ca8e9b0053e6
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
	
	*/
}

