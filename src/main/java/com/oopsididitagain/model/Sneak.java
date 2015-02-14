package com.oopsididitagain.model;


public class Sneak extends Occupation {
	
	public Sneak() {
		this.stats = StatBlob.SNEAK_DEFAULT;
	}

	@Override
	public void doAbility(GameObject target) {
		System.out.println("Doing ability on: " + target);
	}

}
