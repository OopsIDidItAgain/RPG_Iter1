package com.oopsididitagain.model;

import java.awt.Toolkit;

public class Sword extends WearableItem {
	private static final long serialVersionUID = 8490734620366006637L;
	public Sword() {
		name = "Sword";
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/sword.jpg"));
	}
}
