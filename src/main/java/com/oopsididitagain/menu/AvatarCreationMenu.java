package com.oopsididitagain.menu;

import java.util.ArrayList;
import java.util.List;

import com.oopsididitagain.io.KeyCode;

public class AvatarCreationMenu {
	private int currentOption = 0;

	private List<AvatarCreationMenuItem> menuOptions;

	public static final int OCCUPATION = 0;
	public static final int GENDER = 1;
	public static final int HAIRCOLOR = 2;
	public static final int SHIRTCOLOR = 3;
	public static final int CONFIRM = 4;

	public AvatarCreationMenu() {
		menuOptions = new ArrayList<AvatarCreationMenuItem>();
		menuOptions.add(OCCUPATION, new AvatarCreationMenuItem("Occupation", 1,
				3));
		menuOptions.add(GENDER, new AvatarCreationMenuItem("Gender", 1, 2));
		menuOptions.add(HAIRCOLOR, new AvatarCreationMenuItem("Hair Color", 1,
				3));
		menuOptions.add(SHIRTCOLOR, new AvatarCreationMenuItem("Shirt Color",
				1, 3));
		menuOptions.add(CONFIRM, new AvatarCreationMenuItem("Confirm", 0, 0));
	}


	public List<AvatarCreationMenuItem> getMenuOptions() {
		return menuOptions;
	}

	public int getCurrentOption() {
		return currentOption;
	}
	public String getCurrentOptionString(){
		return menuOptions.get(currentOption).displayValue();
	}

	// @Override
	public void changeMenuOption(int keyCode) {
		changeOptionType(keyCode);
		changeOptionValue(keyCode);
	}

	public void changeOptionType(int input) {
		switch (input) {
		case KeyCode.NORTH:
			if (currentOption > 0) {
				currentOption--;
			}
			break;
		case KeyCode.SOUTH:
			if (currentOption < menuOptions.size()-1) {
				currentOption++;
			}
			break;
		default:
			break;
		}
	}

	public void changeOptionValue(int input) {
		switch (input) {
		case KeyCode.EAST:
			menuOptions.get(currentOption).increaseValue();
			break;
		case KeyCode.WEST:
			menuOptions.get(currentOption).decreaseValue();
			break;
		default:
			break;
		}
	}

}
