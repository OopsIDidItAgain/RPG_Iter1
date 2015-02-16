package com.oopsididitagain.model;

public class Summoner extends Occupation{

	public Summoner() {
		this.stats = StatBlob.SUMMONER_DEFAULT;
	}

	@Override
	public String toSaveFormat() {
		return "Summoner";
	}

	@Override
	public String toString() {
		return "Summoner";
	}
	
}
