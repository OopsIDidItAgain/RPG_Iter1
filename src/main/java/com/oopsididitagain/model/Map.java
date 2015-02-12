package com.oopsididitagain.model;

public class Map {
	Tile [][] tiles;

	public Map(Tile[][] tiles) {
		super();
		this.tiles = tiles;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public Tile getATile(int x, int y){
		
		return tiles[x][y];
	}

}
