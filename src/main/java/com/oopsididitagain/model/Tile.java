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
		items = new ArrayList<Item>();
		areaEffect = new AreaEffect(0, 0);
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
		detectItemCollision();
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
		
		if (items != null && items.size() > 0) {
			for (Item item: items) {
				images.add(item.getImage());
			}
		}
		//if (decal != null) images.add(decal.getImage());
		if (entity != null) images.add(entity.getImage());
		return images;
	}

	private void detectItemCollision() {
		for (int i = items.size() - 1; i >= 0; --i) {
			Item item = items.get(i);
			if (item instanceof TakeableItem) {
				entity.addToInventory((TakeableItem)item);
				items.remove(i);
			}
			if (item instanceof OneShotItem) {
				System.out.println(items);
				System.out.println(entity);
				if (entity != null) {
					entity.visit((OneShotItem)item);
					items.remove(i);
				}
			}
		}
	}
}
