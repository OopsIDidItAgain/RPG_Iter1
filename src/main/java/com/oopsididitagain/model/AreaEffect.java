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
	private int rate; //rate at which effects happen in units/second; -1 denotes instant
	private Decal decal;
	private StatBlob areaBlob;
	
	public AreaEffect(int type, int rate) {
		this.type = type;
		this.rate = rate;
		initializeBlob(type, rate);
		
		decal = Decal.AREA_EFFECTS[type];
	}
	
	private void initializeBlob(int type, int rate) {
		switch(type) {
			case 1:
				areaBlob = new StatBlob(0, 0, 0, 0, 0, 0, 0, -rate * 0.005, 0);
				break;
			case 2:
				areaBlob = new StatBlob(0, 0, 0, 0, 0, 0, 0, rate * 0.005, 0);
				break;
			case 3:
				areaBlob = new StatBlob(0, 0, 0, 0, 0, 0, 0, -1000000, 0);
				break;
			case 4:
				areaBlob = new StatBlob(0, 0, 0, 0, 0, 10 * 0.005, 0, 0, 0);
				break;
			default:
				areaBlob = new StatBlob(0, 0, 0, 0, 0, 0, 0, 0, 0);
				break;
		}
	}
	
	public void affect(Entity entity) {
		entity.getStats().mergeBlob(areaBlob);
	}
	
	public Decal getDecal() { return decal; }
}