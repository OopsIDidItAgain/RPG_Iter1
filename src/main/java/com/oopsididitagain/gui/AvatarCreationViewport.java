package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.List;

import javax.imageio.ImageIO;

import com.oopsididitagain.menu.AvatarCreationMenu;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.util.CSVTool;

public class AvatarCreationViewport {
	private AvatarCreationMenu avatarCreationMenu;
	BufferedImage image;

	public AvatarCreationViewport(AvatarCreationMenu avatarCreationMenu){
		super();
		this.avatarCreationMenu = avatarCreationMenu;
		/*
		this.avatarCreationMenu = avatarCreationMenu;
		String[][] pixelImage = new String [1][4];
		pixelImage = CSVTool.readImage("/avatarImage.csv");
		Color myred = new Color(255, 0, 0); // Color white
		Color myblue = new Color(0,255 , 0); // Color white
		int type = BufferedImage.TYPE_INT_ARGB;
		System.out.println("display");
		BufferedImage img = new BufferedImage(100, 100, type);
		WritableRaster raster = img.getRaster();
		
		for(int i = 0; i!= 100; ++i){
			for(int j = 0; j!= 100; ++j){
				
				System.out.println("hi" + pixelImage[0][i] + "la");
				if(pixelImage[0][i].equals("1")){
					img.setRGB(i, j, 0xFF66FF);
			}
				else if(pixelImage[0][i].equals("2")){
					img.setRGB(i,j, 0xFF66FF);
				}
				else{
				
				int r = 255;
				int g = 0;
				int b = 0;
				
				int col = (r << 16) | (g << 8) | b;
				img.setRGB(j, i, col);
				}
			}
		}
*/


	//ImageIO.write(img, "jpg", new File("D:\\test.jpg"));
	//this.image = img;
		
		
	}
	public void displayAvatarCreation(Graphics g){
		//Graphics gr = image.getGraphics();
		
		//System.out.println(image.getHeight());
		int optionType = avatarCreationMenu.getOptionType();
		int selectedOption = avatarCreationMenu.getSelectedOption();
		
		switch(optionType){
		case 1:
			g.drawString("Choose Your Occupation", 100, 250);
			switch(selectedOption){
			case 0:
				g.drawString("Sneak", 100, 300);
				break;
			case 1:
				g.drawString("Summoner", 100, 350);
				break;
			case 2:
				g.drawString("Smasher", 100, 550);
				break;
			}
			break;
		}
		
		
	}
	
	

}
