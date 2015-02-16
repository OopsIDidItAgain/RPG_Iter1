package com.oopsididitagain.model;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Tile {
	private Entity entity;
	private List<Item> items;
	private InteractiveItem interactiveItem;
	private Terrain terrain;
	private AreaEffect areaEffect;

	private Decal decal;
	private Position position;
	
	public Decal getDecal() {
		return decal;
	}
	

	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public Tile(Terrain terrain) {
		super();
		this.terrain = terrain;
		items = new ArrayList<Item>();
		areaEffect = new AreaEffect(0, 0);
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
		this.terrain.setTime(System.currentTimeMillis());
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
	public void setItem(Item item) {
		items.add(item);
	}

	public void setInteractiveItem(InteractiveItem item) {
		this.interactiveItem = item;
	}
	
	public List<Image> getImages() {
		List<Image> images = new ArrayList<Image>();
		images.add(terrain.getImage());
		
		if (items != null && items.size() > 0) {
			for (Item item: items) {
				images.add(item.getImage());
			}
		}
		if (interactiveItem != null) images.add(interactiveItem.getImage());
		
		if (areaEffect.getDecal() != null) images.add(areaEffect.getDecal().getImage());
		if (entity != null) images.add(entity.getImage());
		return images;
	}

	private void detectItemCollision() {
		
		for (int i = items.size() - 1; i >= 0; --i) {
			Item item = items.get(i);
			if (item instanceof TakeableItem) {
				if(entity!=null){
				entity.addToInventory((TakeableItem)item);
				items.remove(i);
				}
			}
			if (item instanceof OneShotItem) {
				if (entity != null) {
					entity.visit((OneShotItem)item);
					items.remove(i);
				}
			}
		}
	}

	public void interact() {
		if(interactiveItem != null) {
			interactiveItem.affect();
		}
	}

	public InteractiveItem getInteractiveItem() {
		return interactiveItem;
	}
}
