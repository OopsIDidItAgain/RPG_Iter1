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
		int width;
		int hieght;
		int top;
		int bottom;
		int left;
		int right;
		int widthpos = 0;
		int heightpos = 0;
		Image img;
		int h = getHeight() / 10;
		int w = getWidth() / 10;
		for(int i = 0; i != 10; ++i){
			for(int j = 0; j != 10; ++j){
				img = areaViewport.getMap().getATile(i,j).getTerrain().getImage();
				g.drawImage(img,widthpos, heightpos, h, w, null);
				repaint();
				widthpos += w;
			}
			widthpos = 0;
			heightpos += h;
		}

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
