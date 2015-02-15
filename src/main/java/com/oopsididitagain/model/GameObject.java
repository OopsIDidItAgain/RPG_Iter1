package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.Serializable;
import java.nio.file.DirectoryIteratorException;

import com.oopsididitagain.util.Direction;

public abstract class GameObject implements Serializable {
	private static final long serialVersionUID = 1745256945975212222L;
	protected Position position;
	protected Image image;
    protected String name;
    protected Direction facing;
    

	public GameObject(String name, String imageName, Position position) {
    	this.name = name;
    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource(imageName));
    	this.position = position;
    	this.facing = Direction.NORTH;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
    	return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Direction getFacing() {
		return facing;
	}

	public void setFacing(Direction facing) {
		this.facing = facing;
	}
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
		sb.append(name + "\n");
		sb.append(position);
		return sb.toString();
    }
}
