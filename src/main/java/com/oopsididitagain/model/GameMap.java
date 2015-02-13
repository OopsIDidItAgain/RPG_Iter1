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
	
	/*
	 public void setNeighbors() {

					
				boolean[] skip = {false, false, false, false, true, false, false, false, false};
				if(x == 0) {
					skip[0] = true;
					skip[3] = true;
					skip[6] = true;
				} else if(x == width - 1) {
					skip[2] = true;
					skip[5] = true;
					skip[8] = true;
				}
				
				if(y == 0) {
					skip[6] = true;
					skip[7] = true;
					skip[8] = true;
				} else if(y == map.getHeight() - 1) {
					skip[0] = true;
					skip[1] = true;
					skip[2] = true;
				}
				
				for(int i = x - 1; i <= x + 1; i++) {
					for(int j = y - 1; j <= y + 1; j++) {
						int k = (i - (x - 1)) + 3*((y + 1) - j);
						if(!skip[k]) {
							neighbors[k] = map.getTileAt(i, j);
						}
					}
				}
			}
		 * [0] == SOUTHWEST
		 * [1] == SOUTH
		 * [2] == SOUTHEAST
		 * [3] == WEST
		 * [4] == 
		 * [5] == EAST
		 * [6] == NORTHWEST
		 * [7] == NORTH
		 * [8] == NORTHEAST
		
	}*/
	
	public boolean checkIfValid(Position pos) {
		if (pos.getY() > height - 1) return false;
		if (pos.getX() > width - 1) return false;
		Tile tile = tiles[pos.getY()][pos.getX()];
		if (tile.getEntity() != null) return false;
		if (!tile.getTerrain().isMovableOnGround()) return false;
		if (!tile.getTerrain().isMovableInAir()) return false;
		/*
		 * List<Item> items = tile.getItems();
		 * for (Item item: items) {
			if (item.)
		}*/
		return true;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
