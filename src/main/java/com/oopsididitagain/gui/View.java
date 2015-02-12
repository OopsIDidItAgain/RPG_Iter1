package com.oopsididitagain.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import com.oopsididitagain.controller.states.GameState;

public class View extends JPanel {

	private static final long serialVersionUID = 8740227504423945127L;
	private AreaViewport areaViewport;
	private StatsViewport statsViewport;


	public View(AreaViewport areaViewport, StatsViewport statsViewport) {
		super();
		this.areaViewport = areaViewport;
		this.statsViewport = statsViewport;
	}

	private void showImage(Graphics g) {
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Zelda-Light-World.jpg"));
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		showImage(g);
	}

	public void render(GameState state) {
		// define render method for view
		
	}


}
