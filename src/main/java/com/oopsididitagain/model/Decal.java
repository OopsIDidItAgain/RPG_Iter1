package com.oopsididitagain.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.oopsididitagain.util.Saveable;

public class Decal implements Saveable {
	public final static Decal HEART_DECAL = new Decal("/decals/heart_decal.png");
	public final static Decal[] AREA_EFFECTS = {
		null,
		new Decal("/decals/take_damage.png"),
		new Decal("/decals/heal_damage.png"),
		new Decal("/decals/instant_death.png"),
		new Decal("/decals/level_up.png")
	};
	
	
	
	Image img;
	
	public Decal(Image img) {
		this.img = img;
	}
	
	public Decal(String imageLink) { 
		// as in new Decal("/heart.png");
		img = Toolkit.getDefaultToolkit()
				.createImage(getClass().getResource(imageLink));
		
		// JLabel picLabel = new JLabel(new ImageIcon(img));
		// JOptionPane.showMessageDialog(null, picLabel, "About", JOptionPane.PLAIN_MESSAGE, null);
	}
	
	public Image getImage() {
		return img;
	}
	
	public void setImage(Image img) {
		this.img = img;
	}

	@Override
	public String toSaveFormat() {
		// TODO Auto-generated method stub
		return null;
	}
}
