package com.oopsididitagain.model;

public abstract class Item extends GameObject {
	private static final long serialVersionUID = 4933860466914150600L;
	String name;
	public String getName() { return name; }
}

class Sword extends Item {
	private static final long serialVersionUID = 1L;
	public Sword() {name = "Sword";}
}

class Potion extends Item {
	private static final long serialVersionUID = 1L;
	public Potion() {name = "Potion";}
}

class Cape extends Item {
	private static final long serialVersionUID = 1L;
	public Cape() {name="Cape";}

}