package com.oopsididitagain.gui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;

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
		avatar.setImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/avatar.png")));
		Position p = new Position(0,0);
		avatar.setPos(p);
		Tile [][] t = new Tile[60][60];
		Terrain one = Terrain.createTerrain(Terrain.GRASS);
		Terrain two = Terrain.createTerrain(Terrain.MOUNTAIN);
		Terrain three  = Terrain.createTerrain(Terrain.WATER);
		for(int i = 0; i != 60; ++i){
			for(int j = 0; j!= 60; ++j){
				t[i][j] = new Tile(one);
				t[i][++j] = new Tile(two);
				t[i][++j] = new Tile(three);
			}
		}
		t[0][0].setEntity(avatar);
		
		
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
