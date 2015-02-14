package com.oopsididitagain.model;

public abstract class Occupation {
	private StatBlob stats;

	public abstract void doAbility(GameObject target);

	public StatBlob getStats() {
		return stats;
	}
}
