

package com.oopsididitagain.model;
import com.oopsididitagain.model.StatBlob;



public abstract class Occupation {
	public static final int SMASHER = 1;
	public static final int SNEAK = 2;
	public static final int SUMMONER = 3;
	
	protected StatBlob stats;

	public StatBlob getStats() {
		return stats;
	}
}
