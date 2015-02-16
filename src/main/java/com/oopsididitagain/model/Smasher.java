package com.oopsididitagain.model;

public class Smasher extends Occupation{

	public Smasher() {
		this.stats = StatBlob.SMASHER_DEFAULT;
	}

	@Override
	public String toSaveFormat() {
		return "Smasher";
	}

	@Override
	public String toString() {
		return "Smasher";
	}
	
}
