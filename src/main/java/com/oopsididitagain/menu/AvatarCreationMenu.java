package com.oopsididitagain.menu;

import com.oopsididitagain.io.KeyCode;

public class AvatarCreationMenu {
	private int selectedOption = 0;
	private int optionType = 1;
	
	public static final int OCCUPATION = 1;
	public static final int GENDER = 2;
	public static final int HAIRCOLOR = 3;
	public static final int SHIRTCOLOR = 4;
	
	
	private int optionTypeSize(){
		switch(optionType){
		case OCCUPATION:
			return 3;
		case GENDER:
			return 2;
		case HAIRCOLOR:
			return 3;
		case SHIRTCOLOR:
			return 4;
		default:
			return 0;
		}
	}
	
	
	public int getOptionType() {
		return optionType;
	}
	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}
	
	
	
	public int getSelectedOption() {
		return selectedOption;
	}

	//@Override
	public void changeMenuOption(int keyCode) {
		int size = optionTypeSize();
		switch(keyCode){
		case KeyCode.EAST:
			if(selectedOption == size-1 || size == 0);
			else selectedOption += 1;
			break;
		case KeyCode.WEST:
			if(selectedOption == 0);
			else selectedOption -= 1;
			break;
		default:
			break;
		}
		
	}


}
