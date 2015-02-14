package com.oopsididitagain.model;

public abstract class Occupation {
	protected StatBlob stats;

	public abstract void doAbility(GameObject target);

	public StatBlob getStats() {
		return stats;
	}
}
