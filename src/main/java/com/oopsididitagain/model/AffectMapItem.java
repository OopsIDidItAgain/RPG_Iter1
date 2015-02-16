package com.oopsididitagain.model;

import java.util.ArrayList;

public class AffectMapItem extends InteractiveItem {

	private Tile tile;
	private int affect;
	private static final int CHANGE_TO_GRASS = 1;
	private static final int CHANGE_TO_WATER = 2;
	private static final int CHANGE_TO_MOUNTAIN = 3;
	private static final int REMOVE_AREA_EFFECT = 4;
	private static final int REMOVE_ITEMS = 5;

	public AffectMapItem(String name, String imageName, Position position,
			Tile tile, int affect) {
		super(name, imageName, position);
		this.tile = tile;
		this.affect = affect;
	}

	@Override
	public void affect() {
		switch (affect) {
		case CHANGE_TO_GRASS:
			tile.setTerrain(Terrain.createTerrain(Terrain.GRASS));
			break;
		case CHANGE_TO_WATER:
			tile.setTerrain(Terrain.createTerrain(Terrain.WATER));
			break;
		case CHANGE_TO_MOUNTAIN:
			tile.setTerrain(Terrain.createTerrain(Terrain.MOUNTAIN));
			break;
		case REMOVE_AREA_EFFECT:
			tile.setAreaEffect(null);
			break;
		case REMOVE_ITEMS:
			tile.setItems(new ArrayList<Item>());
			break;
		default:
			break;
		}
	}
	
	@Override
	public String toSaveFormat() {
		StringBuilder sb = new StringBuilder("");
		String[] arr = super.toSaveFormat().split(",");
		arr[5] = "AffectMapItem";
		for (String s: arr) 
			sb.append(s + ",");
		sb.append("," + affect);
		return sb.toString();
	}
}
