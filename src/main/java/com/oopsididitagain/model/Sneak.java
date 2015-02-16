package com.oopsididitagain.model;


public class Sneak extends Occupation {
	
	public Sneak() {
		this.stats = StatBlob.SNEAK_DEFAULT;
	}

	@Override
	public String toSaveFormat() {
		return "Sneak";
	}

	@Override
	public String toString() {
		return "Sneak";
	}
}
