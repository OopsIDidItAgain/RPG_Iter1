package com.oopsididitagain.model;

import java.awt.Image;
import java.io.Serializable;

public abstract class GameObject implements Serializable {
	private static final long serialVersionUID = 1745256945975212222L;
	private Position pos;
	private Image image;
    private String name;

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
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
}
