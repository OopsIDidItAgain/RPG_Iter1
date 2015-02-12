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
		int top;
		int bottom;
		int left;
		int right;
		int widthpos = 0;
		int heightpos = 0;
		Image img;
		for(int i = 0; i != 2; ++i){
			for(int j = 0; j != 2; ++j){
				int type = areaViewport.getMap().getATile(i,j).getTerrain().getType();
				if(type == 0){
					img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/water.jpg"));
				}else{
					img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/grass.jpg"));
				}
				g.drawImage(img,widthpos, heightpos, 20, 20, null);
				repaint();
				widthpos += 20;
			}
			heightpos += 20;
			widthpos = 0;
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
