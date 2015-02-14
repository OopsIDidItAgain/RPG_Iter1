package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;

public class PauseMenuViewport extends JPanel{
	
	public PauseMenuViewport() {
		super();
		this.setBackground(new Color(0,0,100));
		this.setPreferredSize(new Dimension(600, 600));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawString("hi", 300, 300);
	}
	public void render(){
		repaint();
		revalidate();
	}

}
