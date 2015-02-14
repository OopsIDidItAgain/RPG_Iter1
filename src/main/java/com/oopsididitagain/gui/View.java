package com.oopsididitagain.gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class View extends JPanel {

	private static final long serialVersionUID = 8740227504423945127L;
	private AreaViewport areaViewport;
	private StatsViewport statsViewport;
	private PauseViewPort pauseViewPort;
	private boolean paused;
	private String currentGameState = "";



	

	public View(AreaViewport areaViewport, StatsViewport statsViewport) {
		super();
		setFocusable(true);
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
	

	public void render(GameState state) {
		if (state instanceof PlayGameState) {
			if(state.toString() == currentGameState){
				this.repaint();
				System.out.println("h");
			}
			else{
				currentGameState = state.toString();
				paused = false;
				GameMap map = ((PlayGameState) state).getGameMap();
				Entity avatar = ((PlayGameState) state).getAvatar();
				this.areaViewport = new AreaViewport(map, avatar);
				this.statsViewport = new StatsViewport();
				this.repaint();
				System.out.println("l");
			}
		} 
		else if(state instanceof PauseGameState) {
			if(state.toString() == currentGameState){
				this.repaint();
			}
			else{
				currentGameState = state.toString();
				paused = true;
				PauseMenu pm = ((PauseGameState) state).getPauseMenu();
				this.pauseViewPort = new PauseViewPort(pm);
				this.repaint();
			}
		}
		}


	@Override
	public void paintComponent(Graphics g) {
		if(currentGameState == "PlayGameState"){
			super.paintComponent(g);
			areaViewport.displayMap(g);
			statsViewport.displayStats(g);
			
		}else if(currentGameState == "PauseGameState"){
			super.paintComponent(g);
			areaViewport.displayMap(g);
			statsViewport.displayStats(g);
			PauseViewPort.displayPauseMenu(g);
		}
		
	}
	
	
	


}
