package com.oopsididitagain.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

public class Main extends JFrame {

	private static final long serialVersionUID = -4222070071039252746L;
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main main = new Main();
				main.initialize();
			}
	    });
	}
	
	private void initialize() {
		this.setLayout(new MigLayout("", "[grow, fill]", "[grow, fill]"));
		AreaViewport areaViewport = new AreaViewport();
		StatsViewport statsViewport = new StatsViewport();
		JPanel mainPanel = new View(areaViewport,statsViewport);
		this.add(mainPanel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null); // places frame into center of screen
		this.setVisible(true);
	}
	
}
