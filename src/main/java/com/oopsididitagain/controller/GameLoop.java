package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.io.KeyboardInput;

public class GameLoop {

	private static GameLoop instance;

	private static GameState state;
	private static Controller controller;
	private KeyboardInput keyboardInput;
	private static View view;

	private GameLoop() {
		state = PlayGameState.getInstance();
		// TODO: keyboard and view singleton?
		this.keyboardInput = new KeyboardInput();
		//view = new View();
	}

	public static GameLoop getInstance() {
		if (instance == null) {
			instance = new GameLoop();
		}
		return instance;
	}

	public void playGame() {
		while (!state.equals(ExitGameState.getInstance())) {
			controller = state.getController();
			int command = keyboardInput.getInput();
			controller.handleInputAndUpdate(state, command);
			view.repaint();
		}
	}
	
	public static void setView(View view) {
		GameLoop.view = view;
	}
}
