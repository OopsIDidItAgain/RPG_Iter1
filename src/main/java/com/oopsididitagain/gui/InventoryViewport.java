package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;
import java.util.HashMap;

import com.oopsididitagain.menu.InventoryMenu;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameObject;
import com.oopsididitagain.model.Inventory;
import com.oopsididitagain.model.Item;

public class InventoryViewport extends Viewport{
	private static InventoryMenu inventoryMenu;
	private static Entity avatar;
	private static Inventory inventory;
	private static Object[] inv;


	public InventoryViewport(InventoryMenu inventoryMenu, Inventory inventory) {
		super();
		this.inventoryMenu = inventoryMenu;
		this.inventory = inventory;
	}

	public static void displayInventoryMenu(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.red);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(120, 90, 360, 360, 20, 20);
        g2.fill(roundedRectangle);
        g2.setPaint(Color.blue);
        RoundRectangle2D roundedRectangle1 = new RoundRectangle2D.Float(140, 150, 320, 280, 20, 20);
        g2.fill(roundedRectangle1);
        g2.setPaint(Color.green);
        
       // Inventory inventory = avatar.getInventory();
        int size = inventory.getSize();
        HashMap<String , Item> hash = inventory.getInventory();
		Collection<Item>item = hash.values();
		inv = item.toArray();
		int count = 0;
        int w = 156;
        int h = 175;
        for(int i = 0; i!= 3; ++i){
        	for(int j = 0; j!= 4; ++j){
        		g2.fillRect(w,h,60,60);
        		if(count < size){
        			Image img = ((GameObject) inv[count]).getImage();
        			g.drawImage(img,w, h, 60, 60, null);
        			++count;
        		}
                w+=76;
                
            }
        	w = 156;
        	h += 85;
        	
 }
        
    	
          
      
		
		
		int option = inventoryMenu.getSelectedOption();
		switch(option){
		case 1:
			g.drawRect(0, 300, 10, 10);
			break;
		case 2:
			g.drawRect(200, 300, 10, 10);
			break;
		case 3:
			g.drawRect(400, 300, 10, 10);
			break;
		}
		
	}

}
