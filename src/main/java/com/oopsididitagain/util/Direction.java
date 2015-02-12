package com.oopsididitagain.util;

public enum Direction {
	SOUTHWEST(1),
	SOUTH(2),
	SOUTHEAST(3),
	WEST(4),
	EAST(6),
	NORTHWEST(7),
	NORTH(8),
	NORTHEAST(9);
	
	private final int keyCode;

	Direction(int keyCode) {
		this.keyCode= keyCode;
	}

	public int getKeyCode() {
		return this.keyCode;
	}
}

