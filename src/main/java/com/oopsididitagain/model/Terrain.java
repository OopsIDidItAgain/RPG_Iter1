package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;

public class Terrain {

	private boolean isMovableOnGround;
	private boolean isMovableInAir;
	private Image image;

	private long timeCreated;
	private int type;

	public final static int GRASS = 0;
	public final static int WATER = 1;
	public final static int MOUNTAIN = 2;
	public final static int SOIL = 3;

	public static Terrain createTerrain(int type) {
		boolean isMovableOnGround;
		boolean isMovableInAir;
		Image image;

		switch (type) {
		case GRASS: {
			isMovableOnGround = true;
			isMovableInAir = true;
			image = Toolkit.getDefaultToolkit().getImage(
					Terrain.class.getResource("/grass.jpg"));
			break;
		}
		case WATER: {
			isMovableOnGround = false;
			isMovableInAir = true;
			image = Toolkit.getDefaultToolkit().getImage(
					Terrain.class.getResource("/water.jpg"));
			break;
		}
		case MOUNTAIN: {
			isMovableOnGround = false;
			isMovableInAir = false;
			image = Toolkit.getDefaultToolkit().getImage(
					Terrain.class.getResource("/mountain.jpg"));
			break;
		}
		case SOIL: {
			isMovableOnGround = true;
			isMovableInAir = true;
			image = Toolkit.getDefaultToolkit().getImage(
					Terrain.class.getResource("/mountain.jpg"));
			// timeCreated = 0;
			break;
		}
		default:
			return null;
		}
		return new Terrain(isMovableOnGround, isMovableInAir, image, type);
	}

	public long getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(long timeCreated) {
		this.timeCreated = timeCreated;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setMovableOnGround(boolean isMovableOnGround) {
		this.isMovableOnGround = isMovableOnGround;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	private Terrain(boolean isMovableOnGround, boolean isMovableInAir,
			Image image, int type) {
		this.isMovableOnGround = isMovableOnGround;
		this.isMovableInAir = isMovableInAir;
		this.image = image;
		this.type = type;
		this.timeCreated = System.currentTimeMillis();

	}

	public void setTime(long time) {
		timeCreated = time;
	}

	public boolean isMovableOnGround() {
		return isMovableOnGround;
	}

	public boolean isMovableInAir() {
		return isMovableInAir;
	}

	public String toString() {
		switch (type) {
		case MOUNTAIN: {
			return "mountain";
		}
		case SOIL: {
			return "soil";
		}
		case GRASS: {
			return "grass";
		}
		case WATER: {
			return "water";
		}
		default: {
			return " ";
		}
		}
	}

	public Image getImage() {
		return image;
	}

	public boolean isWater() {
		return !isMovableOnGround && isMovableInAir;
	}
}
