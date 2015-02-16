package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.oopsididitagain.util.Direction;
import com.oopsididitagain.util.Saveable;

public abstract class GameObject implements Saveable {
	protected Position position;
	protected Image image;
	protected String imageName;
    protected String name;
    protected boolean isFlying;

	public GameObject(String name, String imageName, Position position) {
    	this.name = name;
    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource(imageName));
    	this.imageName = imageName;
    	this.position = position;
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

	public void setFacing(Direction facing) {
		this.position.setFacing(facing);
		if(!isFlying) {
			switch(facing) {
				case NORTH:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/n.png"));
			    	break;
				case NORTHEAST:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/ne.png"));
			    	break;
				case EAST:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/e.png"));
			    	break;
				case SOUTHEAST:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/se.png"));
			    	break;
				case SOUTH:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/s.png"));
			    	break;
				case SOUTHWEST:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/sw.png"));
			    	break;
				case WEST:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/w.png"));
			    	break;
				case NORTHWEST:
			    	this.image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/avatar_images/nw.png"));
			    	break;
			    default:
			    	break;
			}
		}
	}
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
		sb.append(name + "\n");
		sb.append(position);
		return sb.toString();
    }
    
    @Override
    public String toSaveFormat() {
    	StringBuilder sb = new StringBuilder("");
    	sb.append(position.toSaveFormat() + "," + imageName + "," + name);
    	return sb.toString();
    }
}
