package com.oopsididitagain.gui;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;


public class AreaViewport extends Viewport{
	private GameMap map;
	private Entity avatar;
	public static final int TILE_SIZE = 20;//in pixels
	
	public AreaViewport(GameMap map, Entity avatar) {
		super();
		this.map = map;
		this.avatar = avatar;
	}
	
	
	
	public GameMap getMap() {
		return map;
	}

	public void setMap(GameMap map) {
		this.map = map;
	}

	public Entity getAvatar() {
		return avatar;
	}

	public void setAvatar(Entity avatar) {
		this.avatar = avatar;
	}

/*

	public int getxCoord1(){
		int x = avatar.getPos().getX();
		
	}
	public int getxCoord2(){
		
	}	
	public int getyCoord(){
		
	}	

*/
	
	

}
