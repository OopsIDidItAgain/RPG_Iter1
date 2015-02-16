

package com.oopsididitagain.model;
import com.oopsididitagain.model.StatBlob;
import com.oopsididitagain.util.Saveable;



public abstract class Occupation implements Saveable {
	public static final int SMASHER = 1;
	public static final int SNEAK = 2;
	public static final int SUMMONER = 3;
	
	protected StatBlob stats;

	public StatBlob getStats() {
		return stats;
	}
	
}
