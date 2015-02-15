package com.oopsididitagain.menu;

import com.oopsididitagain.controller.states.AvatarCreationGameState;
import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.LoadGameState;
import com.oopsididitagain.controller.states.StartGameState;
import com.oopsididitagain.io.KeyCode;

public class StartMenu extends Menu {
	public static final int NEW_GAME = 1;
	public static final int LOAD_GAME = 2;
	public static final int EXIT_GAME = 3;
	private int selectedOption;

	public StartMenu() {
		selectedOption = 1;
	}

	@Override
	public void changeMenuOption(int keyCode) {
		switch (keyCode) {
		case KeyCode.NORTH:
			if (selectedOption == NEW_GAME)
				selectedOption = NEW_GAME;
			else if (selectedOption == LOAD_GAME)
				selectedOption = NEW_GAME;
			else
				selectedOption = LOAD_GAME;
			break;
		case KeyCode.SOUTH:
			if (selectedOption == NEW_GAME)
				selectedOption = LOAD_GAME;
			else if (selectedOption == LOAD_GAME)
				selectedOption = EXIT_GAME;
			else
				selectedOption = EXIT_GAME;
			break;
		default:
			break;
		}
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	public GameState doSelectOption() {
		GameState state = StartGameState.getInstance();
		switch(selectedOption) {
		case NEW_GAME:
			state = AvatarCreationGameState.getInstance();
			break;
		case LOAD_GAME:
			state = LoadGameState.getInstance();
			break;
		case EXIT_GAME:
			state = ExitGameState.getInstance();
			break;
		default:
			break;
		}
		
		return state;
	}

}
