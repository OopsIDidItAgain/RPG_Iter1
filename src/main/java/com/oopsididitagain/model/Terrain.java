package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.oopsididitagain.util.Saveable;

public class Terrain {
	private final boolean isMovableOnGround;
	private final boolean isMovableInAir;
	private final Image image;
	private int type;
	
	public final static int GRASS = 0;
	public final static int WATER = 1;
	public final static int MOUNTAIN = 2;
	
	public static Terrain createTerrain(int type) {
		boolean isMovableOnGround;
		boolean isMovableInAir;
		Image image;
		switch (type) {
			case GRASS: {
				isMovableOnGround = true;
				isMovableInAir = true;
				image = Toolkit.getDefaultToolkit().getImage(Terrain.class.getResource("/grass.jpg"));
				break;
			}
			case WATER: {
				isMovableOnGround = false;
				isMovableInAir = true;
				image = Toolkit.getDefaultToolkit().getImage(Terrain.class.getResource("/water.jpg"));
				break;
			}
			case MOUNTAIN: {
				isMovableOnGround = false;
				isMovableInAir = false;
				image = Toolkit.getDefaultToolkit().getImage(Terrain.class.getResource("/mountain.jpg"));
				break;
			}
			default: return null;
		}
		return new Terrain(isMovableOnGround, isMovableInAir, image, type);
	}
	
	private Terrain(boolean isMovableOnGround, boolean isMovableInAir, Image image, int type) {
		this.isMovableOnGround = isMovableOnGround;
		this.isMovableInAir = isMovableInAir;
		this.image = image;
		this.type = type;
	}

	public boolean isMovableOnGround() {
		return isMovableOnGround;
	}

	public boolean isMovableInAir() {
		return isMovableInAir;
	}

	public Image getImage() {
		return image;
	}

	public int getType() {
		return type;
	}
	
}

