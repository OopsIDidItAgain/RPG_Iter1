package com.oopsididitagain.menu;

import com.oopsididitagain.io.KeyCode;

public class PauseMenu extends Menu{
	private static final int MENU_OPTION_1_SAVE = 1;
	private static final int MENU_OPTION_2_EXIT = 2;
	private static final int MENU_OPTION_3_UNPAUSE = 3;
	private int selectedOption = 1;
	

	public void changeMenuOption(int keyCode) {
		switch(keyCode){
		case KeyCode.NORTH:
			if(selectedOption == 1)selectedOption = 1;
			else if(selectedOption == 2)selectedOption = 1;
			else selectedOption = 2;
			break;
		case KeyCode.SOUTH:
			if(selectedOption == 1)selectedOption = 2;
			else if(selectedOption == 2)selectedOption = 3;
			else selectedOption = 3;
			break;
		default:
			break;
	}
	}
	public int getSelectedOption(){
		return selectedOption;
	}

}
