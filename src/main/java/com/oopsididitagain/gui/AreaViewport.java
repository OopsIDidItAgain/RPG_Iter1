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

	public int getLeft(){
<<<<<<< HEAD
		int x = avatar.getPos().getX();
=======
		int x = avatar.getPos().getY();
>>>>>>> origin/master
		int w = map.getWidth();
		if(x<5){
			return 0;
		}else if(x > (w - 5)){
			return w -10;
		}else{
			return x-5;
		}
		
	}
	public int getRight(){
<<<<<<< HEAD
		int x = avatar.getPos().getX();
=======
		int x = avatar.getPos().getY();
>>>>>>> origin/master
		int w = map.getWidth();
		if(x<5){
			return 10;
		}else if(x > (w - 5)){
			return w;
		}else{
			return x+5;
		}
	}	
	public int getTop(){
<<<<<<< HEAD
		int y = avatar.getPos().getY();
=======
		int y = avatar.getPos().getX();
>>>>>>> origin/master
		int h = map.getHeight();
		if(y<5){
			return 0;
		}else if(y > (h - 5)){
			return h - 10;
		}else{
			return y-5;
		}
		
	}
	public int getBottom(){
<<<<<<< HEAD
		int y = avatar.getPos().getY();
=======
		int y = avatar.getPos().getX();
>>>>>>> origin/master
		int h = map.getHeight();
		if(y<5){
			return 10;
		}else if(y > (h - 5)){
			return h;
		}else{
			return y+5;
		}
		
		
	}
		


	
	

}
