package com.oopsididitagain.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Tile {
	private Entity entity;
	private List<Item> items;
	private Terrain terrain;
	private AreaEffect areaEffect;
	private Decal decal;
	private Tile[] neighbors;
	private int x;
	private int y;
	
	public Decal getDecal() {
		return decal;
	}

	public Tile(Terrain terrain, int x, int y) {
		super();
		this.terrain = terrain;
		this.x = x;
		this.y = y;
		
		neighbors = new Tile[9];
		
	}

	public void setNeighbors(GameMap map) {
		/**
		 * [0] == SOUTHWEST
		 * [1] == SOUTH
		 * [2] == SOUTHEAST
		 * [3] == WEST
		 * [4] == 
		 * [5] == EAST
		 * [6] == NORTHWEST
		 * [7] == NORTH
		 * [8] == NORTHEAST
		 */
		boolean[] skip = {false, false, false, false, true, false, false, false, false};
		if(x == 0) {
			skip[0] = true;
			skip[3] = true;
			skip[6] = true;
		} else if(x == map.getWidth() - 1) {
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
	
	public void setDecal(Decal decal) {
		this.decal = decal;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public AreaEffect getAreaEffect() {
		return areaEffect;
	}

	public void setAreaEffect(AreaEffect areaEffect) {
		this.areaEffect = areaEffect;
	}
	
	public Entity getEntity() {
		return entity;
	}
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	public List<Image> getImages() {
		List<Image> images = new ArrayList<Image>();
		images.add(terrain.getImage());
		
		if (entity != null) images.add(entity.getImage());
		if (items != null && items.size() > 0) {
			for (Item item: items) {
				images.add(item.getImage());
			}
		}
		//if (decal != null) images.add(decal.getImage());
		return images;
	}

	
}
