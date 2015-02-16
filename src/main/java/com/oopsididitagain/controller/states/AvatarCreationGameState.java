package com.oopsididitagain.controller.states;

import java.util.List;

import com.oopsididitagain.controller.AvatarCreationController;
import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.menu.AvatarCreationMenu;
import com.oopsididitagain.model.AffectMapItem;
//import com.oopsididitagain.model.AffectMapItem;
import com.oopsididitagain.model.AreaEffect;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.Occupation;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.Smasher;
import com.oopsididitagain.model.Sneak;
import com.oopsididitagain.model.Summoner;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;
import com.oopsididitagain.util.CSVTool;

public class AvatarCreationGameState extends GameState{
	
	
	private static AvatarCreationGameState instance;
	private static AvatarCreationMenu avatarCreationMenu;
	private static Entity avatar;
	private static GameMap map;
	
	private AvatarCreationGameState() {
		// TODO: get menu and pause game things
		avatarCreationMenu = new AvatarCreationMenu();
		
	}

	private void createMap() {
		Terrain one = Terrain.createTerrain(Terrain.GRASS);
		Terrain two = Terrain.createTerrain(Terrain.MOUNTAIN);
		Terrain three = Terrain.createTerrain(Terrain.WATER);
		Terrain four = Terrain.createTerrain(Terrain.SOIL);

		int width;
		int height;
		String[][] maparr = CSVTool.readMap("/mapDatabase.csv");
		height = maparr.length;
		width = maparr[0].length;

		Tile[][] t = new Tile[height][width];

		for (int i = 0; i != height; ++i) {
			for (int j = 0; j != width; ++j) {
				String terrain = maparr[i][j];
				if (terrain.equals("g")) {
					t[i][j] = new Tile(one);
				} else if (terrain.equals("m")) {
					t[i][j] = new Tile(two);
				} else if (terrain.equals("w")) {
					t[i][j] = new Tile(three);
				}else if (terrain.equals("s")) {
					t[i][j] = new Tile(four);
				}

			}
		}

		t[0][0].setEntity(avatar);
		t[0][3].setAreaEffect(new AreaEffect(1,5)); 
		t[0][4].setAreaEffect(new AreaEffect(2,5)); 
		t[0][5].setAreaEffect(new AreaEffect(3,5)); 
		t[0][6].setAreaEffect(new AreaEffect(4,5)); 

		t[3][0].setAreaEffect(new AreaEffect(1, 10)); 
		List<Item> items = CSVTool.readItemDatabase();

		map = new GameMap(t, height, width);
		for (Item i : items) {
			Tile tile = map.getTileAt(i.getPosition());
			tile.setPosition(i.getPosition());
			if (i instanceof AffectMapItem) {
				((AffectMapItem)i).setTile(map.getTileAt(((AffectMapItem) i).getTargetPosition()));
				tile.setInteractiveItem((AffectMapItem)i);
			}
			else
				tile.getItems().add(i);
		}
	}


	public AvatarCreationMenu getAvatarCreationMenu() {
		return avatarCreationMenu;
	}
	

	public void changeOptionType(int input) {
		avatarCreationMenu.changeOptionType(input);
	}
	
	public void changeOptionValue(int input){
		avatarCreationMenu.changeOptionValue(input);
	}
	
	public GameState doSelectOption(){
		GameState state  = this;
		int currentOption = avatarCreationMenu.getCurrentOption();
		if(currentOption == AvatarCreationMenu.CONFIRM){
			avatar = new Entity("Mario", "/avatar.png", new Position(0,0), false);
			int occupation = avatarCreationMenu.getMenuOptions().get(AvatarCreationMenu.OCCUPATION).getCurrentValue();
			switch(occupation){
			case Occupation.SMASHER:
				avatar.changeOccupation(new Smasher());
				break;
			case Occupation.SNEAK:
				avatar.changeOccupation(new Sneak());
				break;
			case Occupation.SUMMONER:
				avatar.changeOccupation(new Summoner());
				break;
			}
			int gender = avatarCreationMenu.getMenuOptions().get(AvatarCreationMenu.GENDER).getCurrentValue();
			switch(gender){
			case 1:
				//avatar.setImage();
				break;
			case 2:
				//avatar.setImage();
				break;
			}
			createMap();
			state = PlayGameState.getInstance();
			((PlayGameState)state).setMap(map);
			((PlayGameState)state).setAvatar(avatar);
		}
		return state;
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
