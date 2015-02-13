package com.oopsididitagain.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.JPanel;

import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class View extends JPanel {

	private static final long serialVersionUID = 8740227504423945127L;
	private AreaViewport areaViewport;
	private StatsViewport statsViewport;
	private boolean paused;

	

	public View(AreaViewport areaViewport, StatsViewport statsViewport) {
		super();
		this.areaViewport = areaViewport;
		this.statsViewport = statsViewport;
	}

	public View() {
		super();
		setFocusable(true);
	}

	public void setAreaViewport(AreaViewport areaViewport) {
		this.areaViewport = areaViewport;
	}
	
	public void setStatsViewport(StatsViewport statsViewport) {
		this.statsViewport = statsViewport;
	}
	
	private void showImage(Graphics g) {
		int width;
		int height;
		int top = areaViewport.getTop();
		int bottom = areaViewport.getBottom();
		int left = areaViewport.getLeft();
		int right = areaViewport.getRight();
		int widthpos = 0;
		int heightpos = 0;
		Image img;
		int h = getHeight() / 10;
		int w = getWidth() / 10;
		for(int i = top; i != bottom; ++i){
			for(int j = left; j != right; ++j){
				img = areaViewport.getMap().getTileAt(i,j).getTerrain().getImage();
				List<Image> images = areaViewport.getMap().getTileAt(i, j).getImages(); 
				for (int k = 0; k < images.size(); ++k) {
					Image image = images.get(k);
					if (k != 0)
						g.drawImage(image, widthpos+5, heightpos+5, h-10, w-10, null);
					else
						g.drawImage(image, widthpos, heightpos, h, w, null);
				}
				//repaint();
				widthpos += w;
			}
			widthpos = 0;
			heightpos += h;
		}
		if(paused) {
			System.out.println("paused");
			g.drawString("PAUSE GAME", getHeight()/2, getWidth()/2);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		//System.out.println("paint component");
		super.paintComponent(g);
		showImage(g);
	}

	public void render(GameState state) {
		if (state instanceof PlayGameState) {
			paused = false;
			GameMap map = ((PlayGameState) state).getGameMap();
			Entity avatar = ((PlayGameState) state).getAvatar();
			this.areaViewport = new AreaViewport(map, avatar);
			this.revalidate();
			this.repaint();
		} else if(state instanceof PauseGameState) {
			paused = true;
			this.revalidate();
			this.repaint();
		} else {
			
		}
	}
	
	public void render(PlayGameState state) {
		
	}


}
