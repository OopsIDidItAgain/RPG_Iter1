package com.oopsididitagain.model;

import java.awt.Toolkit;

public class Potion extends TakeableItem {
	private static final long serialVersionUID = 5886839689094469223L;

	public Potion() {
		name = "Potion";
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/potion.jpg"));
	}
}
