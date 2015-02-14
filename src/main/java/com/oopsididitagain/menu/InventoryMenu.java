package com.oopsididitagain.menu;

import com.oopsididitagain.io.KeyCode;

public class InventoryMenu extends Menu{
	
	private int size;
	private int selectedOption = 0;
	
	

	public InventoryMenu(int size) {
		super();
		this.size = size;
	}

	public int getSelectedOption() {
		return selectedOption;
	}

	@Override
	public void changeMenuOption(int keyCode) {
		switch(keyCode){
		case KeyCode.NORTH:
			if(selectedOption >= 0 && selectedOption < 4);
			else selectedOption -= 4;
			break;
		case KeyCode.SOUTH:
			if(selectedOption >= (size - 4) && selectedOption < size);
			else selectedOption += 4;
			break;
		case KeyCode.EAST:
			if(selectedOption == size-1);
			else selectedOption += (selectedOption + 1)%4;
			break;
		case KeyCode.WEST:
			if(selectedOption == 0);
			else selectedOption += (selectedOption + 1)%4;
			break;
		default:
			break;
	}
	}



	
	

}
