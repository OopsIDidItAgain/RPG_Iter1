package com.oopsididitagain.gui;

import com.oopsididitagain.model.*;
import com.oopsididitagain.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class Main extends JFrame {

	private static final long serialVersionUID = -4222070071039252746L;
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main main = new Main();
				main.initialize();
			}
	    });
	}
	
	private void initialize() {
		this.setLayout(new MigLayout("", "[grow, fill]", "[grow, fill]"));
		
		Entity avatar = new Entity();
		Position p = new Position(0,0);
		avatar.setPos(p);
		Tile [][] t = new Tile[2][2];
		Terrain l = new Terrain(0);
		Terrain m = new Terrain(1);
		t[0][0] = new Tile(l);
		t[0][1] = new Tile(m);
		t[1][0] = new Tile(l);
		t[1][1] = new Tile(m);
		
		GameMap gameMap = new GameMap(t);
		AreaViewport areaViewport = new AreaViewport(gameMap,avatar);
		
		
		StatsViewport statsViewport = new StatsViewport();
		JPanel mainPanel = new View(areaViewport,statsViewport);
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null); // places frame into center of screen
		this.setVisible(true);
	}
	
}
