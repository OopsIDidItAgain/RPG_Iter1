package com.oopsididitagain.model;

import java.io.Serializable;

import com.oopsididitagain.util.Direction;

public class Position implements Serializable {

	private static final long serialVersionUID = 9024258516107330344L;
	private int x;
	private int y;
	private Direction facing;

	public Position( int y, int x, Direction facing) {
		super();
		this.x = x;
		this.y = y;
		this.facing = facing;
	}

	public Position(int y, int x ) {
		super();
		this.x = x;
		this.y = y;
		this.facing = Direction.NORTH;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getFacing() {
		return facing;
	}

	public void setFacing(Direction facing) {
		this.facing = facing;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		sb.append(x + "\n");
		sb.append(y + "\n");
		sb.append(facing + "\n");
		return sb.toString();
	}

}