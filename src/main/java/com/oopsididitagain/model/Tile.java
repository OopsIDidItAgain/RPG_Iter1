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
	
	public Decal getDecal() {
		return decal;
	}

	public Tile(Terrain terrain) {
		super();
		this.terrain = terrain;
	}

	
	public void setDecal(Decal decal) {
		this.decal = decal;
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
