package com.oopsididitagain.controller.states;

import com.oopsididitagain.controller.AvatarCreationController;
import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.menu.AvatarCreationMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.Sneak;

public class AvatarCreationGameState extends GameState{
	
	
	private static AvatarCreationGameState instance;
	private static AvatarCreationMenu avatarCreationMenu;
	private static Entity avatar;
	
	
	private AvatarCreationGameState() {
		// TODO: get menu and pause game things
		this.avatar = new Entity("Mario", "/avatar.png", new Position(0, 0));
		this.avatarCreationMenu = new AvatarCreationMenu();
		
	}
	











	public AvatarCreationMenu getAvatarCreationMenu() {
		return avatarCreationMenu;
	}
	

	public void changeMenuOption(int keyCode){
		avatarCreationMenu.changeMenuOption(keyCode);
	};
	
	public int getSelectedOption(){
		return avatarCreationMenu.getSelectedOption();
	}
	
	
	public void setOptionType(int n){
		avatarCreationMenu.setOptionType(n);
	}
	public int getOptionType(){
		return avatarCreationMenu.getOptionType();
	}
	
	public static GameState getInstance() {
		if ( instance == null ) {
			instance = new AvatarCreationGameState();
		}
		return instance;
	}
	
	public String toString(){
		return "AvatarCreationGameState";
	}
	public void changeAvatar(int optionType, int change){
		switch(optionType){
		case AvatarCreationMenu.OCCUPATION:
			switch(change){
				case 0:
					avatar.changeOccupation(new Sneak());
					break;
				case 1:
					//avatar.changeOccupation(new Summoner());
					break;
				case 2:
					//avatar.changeOccupation(new Smasher());
					break;
			}
			break;
		case AvatarCreationMenu.GENDER:
			switch(change){
			case 0:
				//avatar.setOccupation();
				break;
			case 1:
				//avatar.setOccupation();
				break;
		}
		break;
		case AvatarCreationMenu.HAIRCOLOR:
			switch(change){
			case 0:
				//avatar.setOccupation();
				break;
			case 1:
				//avatar.setOccupation();
				break;
			case 2:
				//avatar.setOccupation();
				break;
		}
		break;
		case AvatarCreationMenu.SHIRTCOLOR:
			switch(change){
			case 0:
				//avatar.setOccupation();
				break;
			case 1:
				//avatar.setOccupation();
				break;
			case 2:
				//avatar.setOccupation();
				break;
			case 3:
				//avatar.setOccupation();
				break;
		}
		break;
			
		}
	}
	
	
	@Override
	public Controller getController() {
		return AvatarCreationController.getInstance();
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}


	public static Entity getAvatar() {
		return avatar;
	}

}
