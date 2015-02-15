package com.oopsididitagain.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Collection;
import java.util.HashMap;

import com.oopsididitagain.menu.InventoryMenu;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameObject;
import com.oopsididitagain.model.Inventory;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.TakeableItem;
import com.oopsididitagain.model.WearableItem;

public class InventoryViewport extends Viewport{
	private static InventoryMenu inventoryMenu;
	private static Entity avatar;
	private static Inventory inventory;
	private static Object[] inv;
	private static int size;
	static Graphics gr; 


	public InventoryViewport(InventoryMenu inventoryMenu, Inventory inventory) {
		super();
		this.inventoryMenu = inventoryMenu;
		this.inventory = inventory;
		size = inventory.getSize();
	}
	
	
	private static void printMatrix(Graphics g,int bottom,int top, int option){
		gr = g;
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.red);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(120, 90, 360, 360, 20, 20);
        g2.fill(roundedRectangle);
        g2.setPaint(Color.blue);
        RoundRectangle2D roundedRectangle1 = new RoundRectangle2D.Float(140, 150, 320, 280, 20, 20);
        g2.fill(roundedRectangle1);
        g2.setPaint(Color.green);
        
        int x = 130, y = 90;
        String[] s = {	"OPTION: "+ option,
        				"Press 'j' or your 'use' key to select/unselect item", 
        				"Press 'i' to close inventory",	
        				"Press 'i' to close inventory"};
        for (int i = 0; i < 3; i++) 
        	g2.drawString(s[i], x, y += g2.getFontMetrics().getHeight());	 
        
       // Inventory inventory = avatar.getInventory();
        
        HashMap<String , Item> hash = inventory.getInventory();
		Collection<Item>item = hash.values();
		size = inventory.getSize();
		inv = item.toArray();
		int count = bottom;
        int w = 156;
        int h = 175;
        for(int i = 0; i!= 3; ++i){
        	for(int j = 0; j!= 4; ++j){
        		if(count < top){
        			Rectangle r = new Rectangle(w,h,60,60);
        			System.out.println(count);
        			if(inv[count] instanceof WearableItem){// fix this later!
        				if(((WearableItem)inv[count]).isEquipped()){
        					 g2.setPaint(Color.red);
        				}
        			}
        			if(count == option){
        				r.grow(10,10);
        				g2.fill(r);
        			}
        			g2.fill(r);
        			Image img = ((GameObject) inv[count]).getImage();
        			g.drawImage(img,w, h, 60, 60, null);
        			++count;
        		}else{
        			Rectangle r = new Rectangle(w,h,60,60);
            		g2.fill(r);
        		}
        		 g2.setPaint(Color.green);
                w+=76;
                
            }
        	w = 156;
        	h += 85;
        	
        }
	}

	public static void displayInventoryMenu(Graphics g){
		int option = inventoryMenu.getSelectedOption();
		int opt1 = option - (option % 12);
		int n = 0;
		int num = 1;
		int opt2 = 0;
		int loop = size/11;
		if(size%11 != 0) ++loop;
		
		while(n<loop){
			if(option <= 11 * num  &&  option >= 12 * n){
				if((size-1) < 11*num){
					opt2= size; 
					break;
				}else{
					opt2= 11*num; 
					break;
				}
			}
			++num;
			++n;
		}
		//System.out.println("opt1:  " + opt1);
		//System.out.println("opt1:  " +opt2);
		//System.out.println("size:  " +size);
		printMatrix(g,opt1,opt2,option);
	
}


	public void visit(WearableItem wearableItem) {
			Graphics2D g2 = (Graphics2D) gr;
			if(wearableItem.isEquipped()){
				 g2.setPaint(Color.red);
			}
	}

	public void visit(TakeableItem takeableItem) {
		// TODO Auto-generated method stub
		
	}
	

}
