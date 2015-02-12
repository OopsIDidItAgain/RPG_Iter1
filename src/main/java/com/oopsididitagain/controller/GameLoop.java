package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.StartGameState;
import com.oopsididitagain.gui.View;

public class GameLoop {

	private static GameLoop instance;

	private static GameState state;
	private static Controller controller;
	private static KeyboardInput input;
	private static View view;

	private GameLoop() {
		state = StartGameState.getInstance();
		// TODO: keyboard and view singleton?
		input = new KeyboardInput();
		view = new View();
	}

	public static GameLoop getInstance() {
		if (instance == null) {
			instance = new GameLoop();
		}
		return instance;
	}

	public static void playGame() {
		while (!state.equals(ExitGameState.getInstance())) {
			int command = KeyCode.EXIT;
			command = input.getInput();
			controller = state.getController();
			controller.handleInputAndUpdate(state, command);
			view.render(state);			
		}
	}
}
