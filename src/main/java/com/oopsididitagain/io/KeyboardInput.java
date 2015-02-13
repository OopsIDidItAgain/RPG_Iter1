package com.oopsididitagain.io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener {
	int input = KeyCode.SOUTH;

	public int getInput() {
		int temp = input;
		input = KeyCode.SOUTH;
		return temp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("KeyCode: " + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("KeyCode: " + e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("KeyCode: " + e.getKeyCode());
	}
	
	
}
