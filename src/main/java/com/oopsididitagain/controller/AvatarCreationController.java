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
			break;
		case KeyCode.SOUTH:
			break;
		case KeyCode.EAST:
		case KeyCode.WEST:
			((AvatarCreationGameState) state).changeMenuOption(input);
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
			int option = ((AvatarCreationGameState) state).getSelectedOption();
			int type = ((AvatarCreationGameState) state).getOptionType();
			((AvatarCreationGameState) state).setOptionType(count+1);
			((AvatarCreationGameState) state).changeAvatar(type,option);
			++count;
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
