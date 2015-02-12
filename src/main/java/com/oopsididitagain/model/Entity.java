package com.oopsididitagain.model;

public class Entity extends GameObject {
	private static final long serialVersionUID = 6897867058695115274L;
    private Inventory inventory;
    private Position position;
    
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
    
    
    
}
