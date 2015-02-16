package com.oopsididitagain.controller.states;

import java.util.ArrayList;
import java.util.List;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.PlayGameController;
import com.oopsididitagain.gui.View;
import com.oopsididitagain.io.KeyCode;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.GameObject;
import com.oopsididitagain.model.InteractiveItem;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.TakeableItem;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;
import com.oopsididitagain.util.Direction;

public class PlayGameState extends GameState {

	private static PlayGameState instance;
	private static GameMap map;
	private List<GameObject> gameObjects;
	private static Entity avatar;
	private List<Tile> terraFormedTiles;
	int carrotid;
	private final static Position ORIGIN_POSITION = new Position(0,0);
	

	private PlayGameState() {
		super();
		terraFormedTiles = new ArrayList<Tile>();
		int carrotid = 0;
	}

	public GameMap getGameMap() {
		return map;
	}

	public Entity getAvatar() {
		return avatar;
	}
	
	public void setMap(GameMap map) {
		this.map = map;
	}
	
	public List<GameObject> getGameObjects() {
		return gameObjects;
	}

	public void setGameObjects(List<GameObject> gameObjects) {
		this.gameObjects = gameObjects;
	}

	public void setAvatar(Entity avatar) {
		this.avatar = avatar;
	}

	public void moveAvatar(int keyCode) {
		if (avatar.shouldDie() && avatar.getStats().getBlob().getLivesLeft() == 0) return;
		
		int x = avatar.getPosition().getX();
		int y = avatar.getPosition().getY();
		Position updatedPosition = new Position(x, y);
		switch (keyCode) {
		case KeyCode.NORTH:
			updatedPosition = new Position(y - 1, x);
			avatar.setFacing(Direction.NORTH);
			break;
		case KeyCode.SOUTH:
			updatedPosition = new Position(y + 1, x);
			avatar.setFacing(Direction.SOUTH);
			break;
		case KeyCode.EAST:
			updatedPosition = new Position(y, x + 1);
			avatar.setFacing(Direction.EAST);
			break;
		case KeyCode.WEST:
			updatedPosition = new Position(y, x - 1);
			avatar.setFacing(Direction.WEST);
			break;
		case KeyCode.NORTH_EAST:
			updatedPosition = new Position(y - 1, x + 1);
			avatar.setFacing(Direction.NORTHEAST);
			break;
		case KeyCode.NORTH_WEST:
			updatedPosition = new Position(y - 1, x - 1);
			avatar.setFacing(Direction.NORTHWEST);
			break;
		case KeyCode.SOUTH_EAST:
			updatedPosition = new Position(y + 1, x + 1);
			avatar.setFacing(Direction.SOUTHEAST);
			break;
		case KeyCode.SOUTH_WEST:
			updatedPosition = new Position(y + 1, x - 1);
			avatar.setFacing(Direction.SOUTHWEST);
			break;

		}
		
		if (map.checkIfValid(updatedPosition, avatar.isFlying())) {
			map.getTileAt(avatar.getPosition()).setEntity(null);
			avatar.setPosition(updatedPosition);
			map.getTileAt(updatedPosition).setEntity(avatar);
		}
	}
	
	public void affectAvatar() {
		map.getTileAt(avatar.getPosition()).getAreaEffect().affect(avatar);
		
		// avatar steps on instant death
		if (map.getTileAt(avatar.getPosition()).getAreaEffect().getType() == 3) { // instant death
			try { Thread.sleep(300);  } 
			catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
			
			if (avatarDies()) /* go_to_game_over_screen() */; 
		}
		
		if (avatar.shouldDie()) if (avatarDies()) /* go_to_game_over_screen() */;
	}
	
	public boolean avatarDies() { // returns true when game is completely over
		map.getTileAt(avatar.getPosition()).setEntity(null);
		avatar.setPosition(ORIGIN_POSITION);
		map.getTileAt(ORIGIN_POSITION).setEntity(avatar);
		
		return (avatar.getStats().dyingLogic());
	}
	
	public void toggleFlight() {
		if(!map.getTileAt(avatar.getPosition()).getTerrain().isWater()) {
			avatar.setFlying(!avatar.isFlying());
		}
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
	
	public void terraform_grow() {
		if (!terraFormedTiles.isEmpty()) {
			int j = 0;
			for (Tile tile : terraFormedTiles) {
				Terrain t = tile.getTerrain();
				Position p = tile.getPosition();
				long time = t.getTimeCreated();
				if ((System.currentTimeMillis() - time) > 5000) {
					//System.out.println("whatt");
					String c = "carrot" + carrotid;
					carrotid++;
					TakeableItem i = new TakeableItem(c, "/carrot.png",p);
					tile.setItem(i);
					terraFormedTiles.remove(j);
					break;
				}
				++j;

			}
		}
	}
	public void terraform(){
		Terrain soil = Terrain.createTerrain(Terrain.SOIL);
		Tile t = map.getTileAt(avatar.getPosition());
		t.setTerrain(soil);
		t.setPosition(avatar.getPosition());
		terraFormedTiles.add(t);
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}
	
	@Override
	public Controller getController() {
		return PlayGameController.getInstance();
	}

	public GameState changeToPauseState() {
		GameState state = PauseGameState.getInstance();
		System.out.print(map);
		((PauseGameState)state).setMap(map);
		((PauseGameState)state).setAvatar(avatar);
		
		return state;
		
	}

	public void interact() {
		Tile t = map.getTileAt(avatar.getPosition());
		t.interact();
	}

}
