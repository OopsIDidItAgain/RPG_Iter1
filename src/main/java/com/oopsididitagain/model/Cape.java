package com.oopsididitagain.model;

import java.awt.Toolkit;

public class Cape extends WearableItem {
	private static final long serialVersionUID = 4760184747198368357L;

	public Cape() {
		name="Cape";
		image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/cape.png"));
	}
}
