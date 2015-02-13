package com.oopsididitagain.model;

public class GameMap {
	Tile [][] tiles;

	public GameMap(Tile[][] tiles) {
		super();
		this.tiles = tiles;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public Tile getTileAt(int x, int y){
		return tiles[x][y];
	}
}
