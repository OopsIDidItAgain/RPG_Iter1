package com.oopsididitagain.model;

public class GameMap {
	private Tile [][] tiles;
	private int width;
	private int height;
	
	
	

	public GameMap(Tile[][] tiles, int height, int width) {
		super();
		this.tiles = tiles;
		this.width = width;
		this.height = height; 
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	
	public Tile getTileAt(int y, int x){
		return tiles[y][x];
	}
	
	public Tile getTileAt(Position pos) {
		return tiles[pos.getY()][pos.getX()];
	}
	
	public boolean checkIfValid(Position pos) {
		if (pos.getY() > height - 1) return false;
		if (pos.getX() > width - 1) return false;
		if (pos.getY() < 0) return false;
		if (pos.getX() < 0) return false;
		Tile tile = tiles[pos.getY()][pos.getX()];
		if (tile.getEntity() != null) return false;
		if (!tile.getTerrain().isMovableOnGround()) return false;
		if (!tile.getTerrain().isMovableInAir()) return false;
		for (Item i: tile.getItems()) 
			if (i instanceof ObstacleItem)
				return false;
		return true;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
