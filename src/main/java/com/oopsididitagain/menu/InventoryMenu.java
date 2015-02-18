package com.oopsididitagain.menu;

import com.oopsididitagain.io.KeyCode;

public class InventoryMenu{

	private int selectedOption = 0;
	

	public int getSelectedOption() {
		return selectedOption;
	}
	

	public void setSelectedOption(int selectedOption) {
		this.selectedOption = selectedOption;
	}


	//@Override
	public void changeMenuOption(int keyCode, int numOfItems) {
		switch(keyCode){
		case KeyCode.NORTH:
			System.out.println("n");
			if(selectedOption < 4);
			else selectedOption -= 4;
			break;
		case KeyCode.SOUTH:
			System.out.println("s");
			System.out.println(selectedOption);
			System.out.println(numOfItems);
			if(selectedOption+4<numOfItems)
				selectedOption += 4;
			break;
		case KeyCode.EAST:
			System.out.println("e");
			System.out.println(selectedOption);
			System.out.println(numOfItems);
			if(selectedOption < numOfItems){
				selectedOption += 1;
			}
			break;
		case KeyCode.WEST:
			System.out.println("w");
			System.out.println(selectedOption);
			System.out.println(numOfItems);
			if(selectedOption != 0)
				selectedOption -= 1;
			break;
		default:
			break;
	}
	}



	
	

}
