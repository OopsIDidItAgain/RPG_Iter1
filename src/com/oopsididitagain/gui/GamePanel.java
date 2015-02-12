package com.oopsididitagain.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 8740227504423945127L;
	
	private void showImage(Graphics g) {
		Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Zelda-Light-World.jpg"));
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		showImage(g);
	}


}
