package com.oopsididitagain.util;

public enum WearableItemType {
	HELMET,
	ARMOR,
	WEAPON,
	BOOTS;
	
	@Override
	public String toString() {
		if (this.equals(HELMET)) {
			return "HELMET";
		}
		else if (this.equals(ARMOR)) {
			return "ARMOR";
		}
		else if (this.equals(WEAPON)) {
			return "WEAPON";
		}
		else {
			return "BOOTS";
		}
	}
}
