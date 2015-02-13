package com.oopsididitagain.model;

public class AreaEffect {
	private int type;
	/*
	 * 0 = none
	 * 1 = take damage
	 * 2 = heal damage
	 * 3 = instant death
	 * 4 = level up
	 */
	private int rate;
		//rate at which effects happen in units/second; -1 denotes instant
	
	public AreaEffect(int type) {
		this.type = type;
		switch(type) {
			case 0:
				rate = 0;
				break;
			case 1:
			case 2:
				rate = 5;
			case 3:
			case 4:
				rate = -1;
				break;
			default:
				break;
		}
	}
	
	public void affect(Entity entity) {
		
	}
}