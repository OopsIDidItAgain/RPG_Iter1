package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class PauseViewPort extends Viewport {	

public PauseViewPort() {
	super();
	this.setBackground(new Color(0,0,100));
	this.setPreferredSize(new Dimension(400, 400));
}

public void render(){
	repaint();
	revalidate();
}


}
