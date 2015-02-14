package com.oopsididitagain.menu;

import com.oopsididitagain.io.KeyCode;

public class InventoryMenu{

	private int selectedOption = 0;
	

	public int getSelectedOption() {
		return selectedOption;
	}

	//@Override
	public void changeMenuOption(int keyCode, int size) {
		switch(keyCode){
		case KeyCode.NORTH:
			System.out.println("n");
			System.out.println(selectedOption);
			System.out.println(size);
			if(selectedOption >= 0 && selectedOption < 4);
			else selectedOption -= 4;
			break;
		case KeyCode.SOUTH:
			System.out.println("s");
			System.out.println(selectedOption);
			System.out.println(size);
			if((selectedOption >= (size - 4)) && (selectedOption <= size));
			else selectedOption += 4;
			break;
		case KeyCode.EAST:
			System.out.println("e");
			System.out.println(selectedOption);
			System.out.println(size);
			if(selectedOption == size-1 || size == 0);
			else selectedOption += 1;
			break;
		case KeyCode.WEST:
			System.out.println("w");
			System.out.println(selectedOption);
			System.out.println(size);
			if(selectedOption == 0);
			else selectedOption -= 1;
			break;
		default:
			break;
	}
	}



	
	

}
