package com.oopsididitagain.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.oopsididitagain.model.AreaEffect;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.ObstacleItem;
import com.oopsididitagain.model.OneShotItem;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.StatBlob;
import com.oopsididitagain.model.TakeableItem;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;
import com.oopsididitagain.model.WearableItem;

public class CSVTool {
	
	public static String[][] readMap(String map){
		String [][] mapArray;
		try {
			InputStream in = CSVTool.class.getResourceAsStream(map);
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			String line = input.readLine();
			line = input.readLine();
			String[] splitLine = line.split(",");
			int width = Integer.parseInt(splitLine[0]);
			int height = Integer.parseInt(splitLine[1]);
			System.out.println(width);
		
			mapArray = new String[height][width];
			int i = 0;
			while ((line = input.readLine()) != null) {
				String [] split = line.split(",");
				for(int j = 0; j!= width; ++j){
					mapArray[i][j] = split[j];
				}
				++i;
			}
			return mapArray;
		
		}catch (IOException ex) {
			System.out.println("You're map failed to load");
			ex.printStackTrace();
		}
		
	System.out.println("You're map failed to load");
	return null;
}
		
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
						item = new ObstacleItem(name, imageName, position);
						System.out.println(imageName);
						break;
					}
					case "Interactive": {
						break;
					}
					case "OneShot": {
						int livesLeft = Integer.parseInt(splitLine[6]);
						int strength = Integer.parseInt(splitLine[7]);
						int agility = Integer.parseInt(splitLine[8]);
						int intellect = Integer.parseInt(splitLine[9]);
						int hardiness = Integer.parseInt(splitLine[10]);
						int experience = Integer.parseInt(splitLine[11]);
						int movement = Integer.parseInt(splitLine[12]);
						int lifeAmount = Integer.parseInt(splitLine[13]);
						int manaAmount = Integer.parseInt(splitLine[14]);
						StatBlob blob = new StatBlob(livesLeft, strength, agility, 
								intellect, hardiness, experience, movement, 
								lifeAmount, manaAmount);
						item = new OneShotItem(name, imageName, position, blob);
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
	
	public static void writeSaveGame(GameMap map, Entity avatar) {
		StringBuilder sb = new StringBuilder("");

		AreaEffect[][] areaEffects = new AreaEffect[map.getTiles().length][map.getTiles()[0].length];
		List<Item> itemsOnMap = new ArrayList<Item>();
		
		sb.append("MAP\n");
		sb.append(map.getTiles().length + "," + map.getTiles()[0].length + "\n");

		for (int i = 0; i < map.getTiles().length; ++i) {
			for(int j = 0; j < map.getTiles()[0].length; ++j) {
				Tile t = map.getTileAt(i, j);
				if (t.getItems() != null && t.getItems().size() > 0) 
					itemsOnMap.addAll(t.getItems());
				if (t.getInteractiveItem() != null)
					itemsOnMap.add(t.getInteractiveItem());
				areaEffects[i][j] = t.getAreaEffect();
				switch(t.getTerrain().getType()) {
					case Terrain.GRASS: {
						sb.append("G");
						break;
					}
					case Terrain.WATER: {
						sb.append("W");
						break;
					}
					case Terrain.MOUNTAIN: {
						sb.append("M");
						break;
					}
				}
				sb.append(",");
			}
			sb.append("\n");
		}
		sb.append("AREAEFFECTS\n");
		for (int i = 0; i < areaEffects.length; ++i) {
			for (int j = 0; j < areaEffects[0].length; ++j) {
				if (areaEffects[i][j].getType() == 0) continue;
				sb.append(i + "," + j + "," + areaEffects[i][j].toSaveFormat() + "\n");
			}
		}
		
		sb.append("ITEMS\n");
		for (Item i: itemsOnMap) {
			sb.append(i.toSaveFormat() + "\n");
		}
		sb.append("AVATAR\n");
		StatBlob blob = new StatBlob(avatar.getStats().getBlob());
		blob.detach(avatar.getOccupation().getStats());
		sb.append(avatar.toSaveFormat() + "\n");
		sb.append("ARMORY\n");
		for (Item i: avatar.getInventory().getInventory().values()) {
			if (i instanceof WearableItem) {
				WearableItem wearable = (WearableItem)i;
				if (wearable.isEquipped()) {
					sb.append(wearable.toSaveFormat() + "\n");
					blob.detach(wearable.getBlob());
				}
			}
		}
		sb.append("INVENTORY_NOT_EQUIPPED\n");
		for (Item i: avatar.getInventory().getInventory().values()) {
			if (i instanceof WearableItem) {
				WearableItem wearable = (WearableItem)i;
				if (!wearable.isEquipped())
					sb.append(wearable.toSaveFormat() + "\n");
			}
			else sb.append(i.toSaveFormat());
		}
		sb.append("BASE_STATS_WITH_NO_OCCUPATION_NO_EQUIPMENT\n");
		sb.append(blob.toSaveFormat());
		try {
			File output = new File(System.getProperty("user.home"), "OOP_SAVEGAME.csv");
			FileWriter writer = new FileWriter(output);
			writer.write(sb.toString());
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

