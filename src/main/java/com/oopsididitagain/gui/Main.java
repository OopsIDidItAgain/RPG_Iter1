package com.oopsididitagain.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import net.miginfocom.swing.MigLayout;

import com.oopsididitagain.controller.GameLoop;

public class Main extends JFrame {

	private static final long serialVersionUID = -4222070071039252746L;
	
	private static GameLoop loop;
	
	public static void main(String[] args) {
		loop = GameLoop.getInstance();
	    SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main main = new Main();
				main.initialize();
			}
	    });

		loop.playGame();
	}
	
	private void initialize() {
		this.setLayout(new MigLayout("", "[grow, fill]", "[grow, fill]"));
		
		this.add(loop.getView());
		
		//JPanel mainPanel = new View(areaViewport,statsViewport);
		//this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null); // places frame into center of screen
		this.setVisible(true);
//		Thread thread = new Thread(new Runnable(){
//			@Override
//			public void run() {
//			}
//		});
//		thread.start();
		
	}
	
}
