package com.oopsididitagain.gui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.oopsididitagain.controller.GameLoop;

public class Main {

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
		//this.setLayout(new MigLayout("", "[grow, fill]", "[grow, fill]"));
		
		//this.add(loop.getView().getJPanel());
		
		
	}
	
}
