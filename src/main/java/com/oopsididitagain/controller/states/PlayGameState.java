package com.oopsididitagain.controller.states;

import java.util.List;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PlayGameController;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.model.AreaEffect;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.GameObject;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.Sneak;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;
import com.oopsididitagain.util.CSVTool;

public class PlayGameState extends GameState {

	private static PlayGameState instance;
	private GameMap map;
	private List<GameObject> gameObjects;
	private Entity avatar;
	

	private PlayGameState() {
		super();
		GameState state =  AvatarCreationGameState.getInstance();
		this.avatar = AvatarCreationGameState.getAvatar();
		Terrain one = Terrain.createTerrain(Terrain.GRASS);
		Terrain two = Terrain.createTerrain(Terrain.MOUNTAIN);
		Terrain three = Terrain.createTerrain(Terrain.WATER);
		Tile[][] t = {
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(one), new Tile(one), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(two), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(three), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(two), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(two), new Tile(three), new Tile(one),
						new Tile(two), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) },
				{ new Tile(one), new Tile(one), new Tile(one), new Tile(one),
						new Tile(two), new Tile(two), new Tile(two),
						new Tile(two), new Tile(two), new Tile(two) }, };
		t[0][0].setEntity(avatar);
		List<Item> items = CSVTool.readItemDatabase();
		
		t[10][3].setAreaEffect(new AreaEffect(1, 5));
		
		map = new GameMap(t, 11, 10);

		for (Item i: items) {
			Tile tile = map.getTileAt(i.getPosition());
			tile.getItems().add(i);
		}
		

	}

	public GameMap getGameMap() {
		return map;
	}

	public Entity getAvatar() {
		return avatar;
	}

	public void moveAvatar(int keyCode) {
		int x = avatar.getPosition().getX();
		int y = avatar.getPosition().getY();
		Position updatedPosition = new Position(x, y);
		switch (keyCode) {
		case KeyCode.NORTH:
			updatedPosition = new Position(y - 1, x);
			break;
		case KeyCode.SOUTH:
			updatedPosition = new Position(y + 1, x);
			break;
		case KeyCode.EAST:
			updatedPosition = new Position(y, x + 1);
			break;
		case KeyCode.WEST:
			updatedPosition = new Position(y, x - 1);
			break;
		case KeyCode.NORTH_EAST:
			updatedPosition = new Position(y - 1, x + 1);
			break;
		case KeyCode.NORTH_WEST:
			updatedPosition = new Position(y - 1, x - 1);
			break;
		case KeyCode.SOUTH_EAST:
			updatedPosition = new Position(y + 1, x + 1);
			break;
		case KeyCode.SOUTH_WEST:
			updatedPosition = new Position(y + 1, x - 1);
			break;

		}

		if (map.checkIfValid(updatedPosition)) {
			map.getTileAt(avatar.getPosition()).setEntity(null);
			avatar.setPosition(updatedPosition);
			map.getTileAt(updatedPosition).setEntity(avatar);
		}
		
		map.getTileAt(avatar.getPosition()).getAreaEffect().affect(avatar);
		System.out.println(avatar.getStats().getBlob().toString());
	}

	public static GameState getInstance() {
		if (instance == null) {
			instance = new PlayGameState();
		}
		return instance;
	}
	public String toString(){
		return "PlayGameState";
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Controller getController() {
		return PlayGameController.getInstance();
	}

}
