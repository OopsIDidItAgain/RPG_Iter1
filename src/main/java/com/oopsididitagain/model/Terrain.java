package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;

public class Terrain {
	private final boolean isMovableOnGround;
	private final boolean isMobableInAir;
	private final Image image;
	
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
		return new Terrain(isMovableOnGround, isMovableInAir, image);
	}
	
	private Terrain(boolean isMovableOnGround, boolean isMovableInAir, Image image) {
		this.isMovableOnGround = isMovableOnGround;
		this.isMobableInAir = isMovableInAir;
		this.image = image;
	}

	public boolean isMovableOnGround() {
		return isMovableOnGround;
	}

	public boolean isMovableInAir() {
		return isMobableInAir;
	}

	public Image getImage() {
		return image;
	}
	
}

