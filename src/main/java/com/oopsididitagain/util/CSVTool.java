package com.oopsididitagain.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.StatBlob;
import com.oopsididitagain.model.TakeableItem;
import com.oopsididitagain.model.WearableItem;

public class CSVTool {
	public static String[][] readImage(String image){
		String [][] img =  new String [1][4];
		try {
			InputStream in = CSVTool.class.getResourceAsStream(image);
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			for(int i = 0; i!= 1; ++i) {
				String line = input.readLine(); // skip headers
				String[] splitLine = line.split(",");
				for(int j = 0; j!= 4; ++j)
					img[i][j] = splitLine[j];
				}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return img;
}

		
	public static List<Item> readItemDatabase() {
		List<Item> items = new ArrayList<Item>();
		try {
			InputStream in = CSVTool.class.getResourceAsStream("/ItemDatabase.csv");
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			
			String line = input.readLine(); // skip headers
			while ((line = input.readLine()) != null) {
				Item item = null;
				String[] splitLine = line.split(",");
				
				String name = splitLine[0];
				String imageName = "/" + splitLine[1];
				int x = Integer.parseInt(splitLine[2]);
				int y = Integer.parseInt(splitLine[3]);
				Position position = new Position(y, x);
				String type = splitLine[4];

				switch (type) {
					case "Wearable": {
						int rank = Integer.parseInt(splitLine[5]);
						int livesLeft = Integer.parseInt(splitLine[6]);
						int strength = Integer.parseInt(splitLine[7]);
						int agility = Integer.parseInt(splitLine[8]);
						int intellect = Integer.parseInt(splitLine[9]);
						int hardiness = Integer.parseInt(splitLine[10]);
						int experience = Integer.parseInt(splitLine[11]);
						int movement = Integer.parseInt(splitLine[12]);
						int lifeAmount = Integer.parseInt(splitLine[13]);
						int manaAmount = Integer.parseInt(splitLine[14]);
						String wearableTypeString = splitLine[15];
						WearableItemType wearableItemType = null;
						switch(wearableTypeString) {
							case "HELMET": wearableItemType = WearableItemType.HELMET;
								break;
							case "ARMOR": wearableItemType = WearableItemType.ARMOR;
								break;
							case "BOOTS": wearableItemType = WearableItemType.BOOTS;
								break;
							case "WEAPON": wearableItemType = WearableItemType.WEAPON;
								break;
						}

						StatBlob blob = new StatBlob(livesLeft, strength, agility, 
								intellect, hardiness, experience, movement, 
								lifeAmount, manaAmount);
						item = new WearableItem(name, imageName, position, rank, blob, 
								wearableItemType);
						break;
					}
					case "Takeable": {
						item = new TakeableItem(name, imageName, position);
						break;
					}
					case "Obstacle": {
						//item = new TakeableItem(false);
						break;
					}
					case "InteractiveItem": {
						//item = new TakeableItem(false);
						break;
					}
					case "OneShotItem": {
						//item = new TakeableItem(false);
						break;
					}
					default: break;
				}
				if (item != null)
					items.add(item);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return items;
	}
}

