package com.oopsididitagain.controller;

import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.AvatarCreationGameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.io.KeyCode;

public class AvatarCreationController extends Controller{
	
private static AvatarCreationController instance;
	
	private AvatarCreationController() {
		
	}

	public static Controller getInstance() {
		if ( instance == null ){
			instance = new AvatarCreationController();
		}
		return instance;
	}

	@Override
	public GameState handleInputAndUpdate(GameState state, int input) {
		int count = 0;
		switch (input) {
		case KeyCode.NORTH:
		case KeyCode.SOUTH:
			((AvatarCreationGameState) state).changeOptionType(input);
			break;
		case KeyCode.EAST:
		case KeyCode.WEST:
			((AvatarCreationGameState) state).changeOptionValue(input);
			break;
		case KeyCode.NORTH_EAST:
			break;
		case KeyCode.NORTH_WEST:
			break;
		case KeyCode.SOUTH_EAST:
			break;
		case KeyCode.SOUTH_WEST:
			break;
		case KeyCode.USE:
			state = ((AvatarCreationGameState) state).doSelectOption();
			break;
		case KeyCode.PAUSE:
			break;
		case KeyCode.EXIT:
			break;
		case KeyCode.INVENTORY:
			break;
		case KeyCode.EQUIP:
			break;
		case KeyCode.ENTER:
			break;
		default:
			break;
		}
		
		if(count == 1){
			System.out.println("one");
			state = PlayGameState.getInstance();
		}
		return state;
	}

}
