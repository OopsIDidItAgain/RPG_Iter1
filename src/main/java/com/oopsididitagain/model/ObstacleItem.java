package com.oopsididitagain.model;

public class ObstacleItem extends Item {

	public ObstacleItem(String name, String imageName, Position position) {
		super(name, imageName, position);
	}

	@Override
	public void accept(Entity visitor) {
		visitor.visit(this);	
	}

}
