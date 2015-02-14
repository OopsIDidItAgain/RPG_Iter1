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
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class View extends JFrame {

	private static final long serialVersionUID = 8740227504423945127L;
	private AreaViewport areaViewport;
	private StatsViewport statsViewport;
	private PauseViewPort pauseViewPort;
	private boolean paused;
	private JPanel JPanelCards;
	private JPanel pane;
	private GameState currentGameState;
	GridBagConstraints c;


	

	public View(AreaViewport areaViewport, StatsViewport statsViewport) {
		super();
		setFocusable(true);
		this.areaViewport = areaViewport;
		this.statsViewport = statsViewport;
	}

	public View() {
		super();
		setFocusable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 700);
		this.setLocationRelativeTo(null); // places frame into center of screen
		this.setTitle("OOPs I Did It Again!");
		this.setVisible(true);
		this.setResizable(false);
		JPanelCards = new JPanel(new CardLayout());

	}
	public JPanel getJPanel(){
		return JPanelCards;
	}

	public void setAreaViewport(AreaViewport areaViewport) {
		this.areaViewport = areaViewport;
	}
	
	public void setStatsViewport(StatsViewport statsViewport) {
		this.statsViewport = statsViewport;
	}
	

	public void render(GameState state) {
		if (state instanceof PlayGameState) {
			if(state == currentGameState){
				areaViewport.render();
				pane.repaint();
			}
			else{
				currentGameState = state;
				paused = false;
				GameMap map = ((PlayGameState) state).getGameMap();
				Entity avatar = ((PlayGameState) state).getAvatar();
				pane = new JPanel(new GridBagLayout());
				//this.add(pane);
				this.areaViewport = new AreaViewport(map, avatar);
				this.statsViewport = new StatsViewport();
				this.add(areaViewport, BorderLayout.NORTH);
				this.add(statsViewport, BorderLayout.SOUTH);
				areaViewport.render();
				statsViewport.render();
				pane.repaint();
				System.out.print("l");
			}
		} else if(state instanceof PauseGameState) {
			if(state == currentGameState){
				pauseViewPort.render();
				pane.repaint();
			}
			else{
				currentGameState = state;
				paused = true;
				this.pauseViewPort = new PauseViewPort();
				this.add(pauseViewPort, BorderLayout.SOUTH);
				pauseViewPort.render();
				pane.repaint();
			}
		} 
	}
	
	public void render(PlayGameState state) {
		
	}


}
