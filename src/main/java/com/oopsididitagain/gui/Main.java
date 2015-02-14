	package com.oopsididitagain.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import com.oopsididitagain.controller.GameLoop;

public class Main{

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
<<<<<<< HEAD
		this.setLayout(new BorderLayout());
		
		this.add(loop.getView(), BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null); // places frame into center of screen
		this.setTitle("OOPs I Did It Again!");
		this.setVisible(true);
=======
		//this.setLayout(new MigLayout("", "[grow, fill]", "[grow, fill]"));
		
		//this.add(loop.getView().getJPanel());
		
>>>>>>> Tess-changingtheview
		
	}
	
}
