package com.oopsididitagain.model;

import java.util.*;

public class Tile {
	private Entity entity;
	private List<Item> items;
	private Terrain t;
	private AreaEffect a;
	private Decal d;
	
	
	public Decal getD() {
		return d;
	}


	public Tile(Terrain t) {
		super();
		this.t = t;
	}

	
	public void setD(Decal d) {
		this.d = d;
	}


	public Terrain getT() {
		return t;
	}

	public void setT(Terrain t) {
		this.t = t;
	}

	public AreaEffect getA() {
		return a;
	}

	public void setA(AreaEffect a) {
		this.a = a;
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
		//this.items = items;
	}

	
}
