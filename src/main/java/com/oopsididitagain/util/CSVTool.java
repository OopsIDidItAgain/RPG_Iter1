package com.oopsididitagain.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.oopsididitagain.model.AreaEffect;
import com.oopsididitagain.model.Armory;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Inventory;
import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.ObstacleItem;
import com.oopsididitagain.model.Occupation;
import com.oopsididitagain.model.OneShotItem;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.Smasher;
import com.oopsididitagain.model.Sneak;
import com.oopsididitagain.model.StatBlob;
import com.oopsididitagain.model.StatCollection;
import com.oopsididitagain.model.Summoner;
import com.oopsididitagain.model.TakeableItem;
import com.oopsididitagain.model.Terrain;
import com.oopsididitagain.model.Tile;
import com.oopsididitagain.model.WearableItem;

public class CSVTool {

	public static String[][] readMap(String map) {
		String[][] mapArray;
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
				String[] split = line.split(",");
				for (int j = 0; j != width; ++j) {
					mapArray[i][j] = split[j];
				}
				++i;
			}
			return mapArray;

		} catch (IOException ex) {
			System.out.println("You're map failed to load");
			ex.printStackTrace();
		}

		System.out.println("You're map failed to load");
		return null;
	}

	public static String[][] readImage(String image) {
		String[][] img = new String[1][4];
		try {
			InputStream in = CSVTool.class.getResourceAsStream(image);
			BufferedReader input = new BufferedReader(new InputStreamReader(in));
			for (int i = 0; i != 1; ++i) {
				String line = input.readLine(); // skip headers
				String[] splitLine = line.split(",");
				for (int j = 0; j != 4; ++j)
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
			InputStream in = CSVTool.class
					.getResourceAsStream("/ItemDatabase.csv");
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
					switch (wearableTypeString) {
					case "HELMET":
						wearableItemType = WearableItemType.HELMET;
						break;
					case "ARMOR":
						wearableItemType = WearableItemType.ARMOR;
						break;
					case "BOOTS":
						wearableItemType = WearableItemType.BOOTS;
						break;
					case "WEAPON":
						wearableItemType = WearableItemType.WEAPON;
						break;
					}

					StatBlob blob = new StatBlob(livesLeft, strength, agility,
							intellect, hardiness, experience, movement,
							lifeAmount, manaAmount);
					item = new WearableItem(name, imageName, position, rank,
							blob, wearableItemType);
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
				default:
					break;
				}
				if (item != null)
					items.add(item);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return items;
	}

	public static void writeSaveGame(GameMap map, Entity avatar, File outputFile) {
		StringBuilder sb = new StringBuilder("");

		AreaEffect[][] areaEffects = new AreaEffect[map.getTiles().length][map
				.getTiles()[0].length];
		List<Item> itemsOnMap = new ArrayList<Item>();

		sb.append("MAP\n");
		sb.append(map.getTiles().length + "," + map.getTiles()[0].length + "\n");

		for (int i = 0; i < map.getTiles().length; ++i) {
			for (int j = 0; j < map.getTiles()[0].length; ++j) {
				Tile t = map.getTileAt(i, j);
				if (t.getItems() != null && t.getItems().size() > 0)
					itemsOnMap.addAll(t.getItems());
				if (t.getInteractiveItem() != null)
					itemsOnMap.add(t.getInteractiveItem());
				areaEffects[i][j] = t.getAreaEffect();
				switch (t.getTerrain().getType()) {
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
				case Terrain.SOIL: {
					sb.append("S");
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
				if (areaEffects[i][j].getType() == 0)
					continue;
				sb.append(i + "," + j + "," + areaEffects[i][j].toSaveFormat()
						+ "\n");
			}
		}

		sb.append("ITEMS\n");
		for (Item i : itemsOnMap) {
			sb.append(i.toSaveFormat() + "\n");
		}
		sb.append("AVATAR\n");
		StatBlob blob = new StatBlob(avatar.getStats().getBlob());
		blob.detach(avatar.getOccupation().getStats());
		sb.append(avatar.toSaveFormat() + "\n");
		sb.append("ARMORY\n");
		for (Item i : avatar.getInventory().getInventory().values()) {
			if (i instanceof WearableItem) {
				WearableItem wearable = (WearableItem) i;
				if (wearable.isEquipped()) {
					sb.append(wearable.toSaveFormat() + "\n");
					blob.detach(wearable.getBlob());
				}
			}
		}
		sb.append("INVENTORY_NOT_EQUIPPED\n");
		for (Item i : avatar.getInventory().getInventory().values()) {
			if (i instanceof WearableItem) {
				WearableItem wearable = (WearableItem) i;
				if (!wearable.isEquipped())
					sb.append(wearable.toSaveFormat() + "\n");
			} else
				sb.append(i.toSaveFormat()+ "\n");
		}
		sb.append("BASE_STATS_WITH_NO_OCCUPATION_NO_EQUIPMENT\n");
		sb.append(blob.toSaveFormat());
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.write(sb.toString());
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static GameMap makeLoadedMap(File loadGameFile) {

		try {
			BufferedReader input = new BufferedReader(new FileReader(
					loadGameFile));
			String line = input.readLine(); // x y skip
			line = input.readLine();// width height
			String[] splitLine = line.split(",");
			int height = Integer.parseInt(splitLine[0]);
			int width = Integer.parseInt(splitLine[1]); // height width
			String[][] m = new String[height][width];
			Tile[][] t = new Tile[height][width];

			for (int i = 0; i != height; ++i) {
				line = input.readLine();// each row
				splitLine = line.split(",");
				for (int j = 0; j != width; ++j) {
					m[i][j] = splitLine[j];
					if (m[i][j].equals("G")) {
						Terrain grass = Terrain.createTerrain(Terrain.GRASS);
						t[i][j] = new Tile(grass);
					} else if (m[i][j].equals("M")) {
						Terrain mountain = Terrain
								.createTerrain(Terrain.MOUNTAIN);
						t[i][j] = new Tile(mountain);
					} else if (m[i][j].equals("W")) {
						Terrain water = Terrain.createTerrain(Terrain.WATER);
						t[i][j] = new Tile(water);
					} else if (m[i][j].equals("S")) {
						Terrain soil = Terrain.createTerrain(Terrain.SOIL);
						t[i][j] = new Tile(soil);

					}
					//System.out.print(t[i][j].);
				}
				System.out.println();
			}
			line = input.readLine();// this is for "AreaEffects"
			// ln(line);

			ArrayList<AreaEffect> aef = new ArrayList<AreaEffect>();
			System.out.println(line);
			line = input.readLine();// each row
			splitLine = line.split(",");
			while (!(splitLine[0].equals("ITEMS"))) {
				System.out.println(line);
				int posx = Integer.parseInt(splitLine[0]);
				int posy = Integer.parseInt(splitLine[1]);
				Position p = new Position(posx,posy);
				int typeae = Integer.parseInt(splitLine[2]);
				int rateae = Integer.parseInt(splitLine[3]);
				AreaEffect a = new AreaEffect(typeae, rateae,p);
				aef.add(a);
				line = input.readLine();// each row
				splitLine = line.split(",");
			}
			
			line = input.readLine();// skipping items
			// ln(line);
			ArrayList<Item> items = new ArrayList<Item>();
			line = input.readLine();
			splitLine = line.split(",");
			while (!splitLine[0].equals("AVATAR")) {// check here!!!!!!!!!
				int x = Integer.parseInt(splitLine[0]);
				int y = Integer.parseInt(splitLine[1]);
				int dir = Integer.parseInt(splitLine[2]);

				String img = splitLine[3];
				String nameID = splitLine[4];
				String itemtype = splitLine[5];
				double livesLeft, intellect, strength, agility, hardiness, experience, movement, lifeAmount, manaAmount;
				int rank;
				switch (itemtype) {
				case "OneShotItem":

					livesLeft = Double.parseDouble(splitLine[7]);
					intellect = Double.parseDouble(splitLine[8]);
					strength = Double.parseDouble(splitLine[9]);
					agility = Double.parseDouble(splitLine[10]);
					hardiness = Double.parseDouble(splitLine[11]);
					experience = Double.parseDouble(splitLine[12]);
					movement = Double.parseDouble(splitLine[13]);
					lifeAmount = Double.parseDouble(splitLine[14]);
					manaAmount = Double.parseDouble(splitLine[15]);

					StatBlob blob = new StatBlob(livesLeft, intellect,
							strength, agility, hardiness, experience, movement,
							lifeAmount, manaAmount);
					Position pr = new Position(x, y, Direction.NORTH);
					OneShotItem oneShotItem = new OneShotItem(nameID, img, pr,
							blob);
					items.add(oneShotItem);
					break;
				case "Wearable":
					// ln(splitLine[7]);
					livesLeft = Double.parseDouble(splitLine[6]);
					intellect = Double.parseDouble(splitLine[7]);
					strength = Double.parseDouble(splitLine[8]);
					agility = Double.parseDouble(splitLine[9]);
					hardiness = Double.parseDouble(splitLine[10]);
					experience = Double.parseDouble(splitLine[11]);
					movement = Double.parseDouble(splitLine[12]);
					lifeAmount = Double.parseDouble(splitLine[13]);
					manaAmount = Double.parseDouble(splitLine[14]);
					String wearableType = splitLine[15];

					WearableItemType wT = null;
					switch (wearableType) {
					case "HELMET":
						wT = WearableItemType.HELMET;
						break;
					case "BOOTS":
						wT = WearableItemType.BOOTS;
						break;
					case "ARMOR":
						wT = WearableItemType.ARMOR;
						break;
					case "WEAPON":
						wT = WearableItemType.WEAPON;
						break;

					}
					rank = Integer.parseInt(splitLine[16]);

					StatBlob wearBlob = new StatBlob(livesLeft, intellect,
							strength, agility, hardiness, experience, movement,
							lifeAmount, manaAmount);
					Position wP = new Position(x, y, Direction.NORTH);
					WearableItem wearableItem = new WearableItem(nameID, img,
							wP, rank, wearBlob, wT);
					items.add(wearableItem);
					break;
				case "ObstacleItem":
					Position oP = new Position(x, y, Direction.NORTH);
					ObstacleItem obstacleItem = new ObstacleItem(nameID, img,
							oP);
					items.add(obstacleItem);
					break;
				case "Takeable":
					Position tP = new Position(x, y, Direction.NORTH);
					TakeableItem takeableItem = new TakeableItem(nameID, img,
							tP);
					items.add(takeableItem);
				default:
					break;
				}
				line = input.readLine();
				splitLine = line.split(",");
			}
			GameMap map = new GameMap(t, height, width);
			
			for (Item i : items) {
				
				Tile tile1 = map.getTileAt(i.getPosition());
				tile1.getItems().add(i);

			}
/*
			for (AreaEffect a : aef) {
				//System.out.println(a.getPosition().getX() +" "+ a.getPosition().getY());
				Tile tile1 = map.getTileAt(a.getPosition());
				tile1.setAreaEffect(a);

			}
*/

			return map;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public static Entity makeLoadedAvatar(File loadGameFile) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(
					loadGameFile));
			String line = input.readLine(); // x y skip
			String[] splitLine = line.split(",");
			line = input.readLine();// skipping items
			ArrayList<Item> items = new ArrayList<Item>();
			System.out.println(line);
			while (!(splitLine[0].equals("AVATAR"))) {// check here!!!!!!!!!
				line = input.readLine();
				splitLine = line.split(",");
			}
			line = input.readLine();
			splitLine = line.split(",");
			String image = splitLine[3];
			String occupation = splitLine[5];
			int postionx = Integer.parseInt(splitLine[0]);
			int positiony = Integer.parseInt(splitLine[1]);
			String isflying = splitLine[6];
			Position p = new Position(postionx, positiony, Direction.NORTH);
			boolean isFlying = false;
			if (isflying.equals("TRUE")) {
				isFlying = true;
			}

			
			
			
			
			
			
			
			
			ArrayList<Item> armory = new ArrayList<Item>();
			Armory armory1 = new Armory();
			line = input.readLine();
			line = input.readLine();
			splitLine = line.split(",");
			 while(!(splitLine[0].equals("INVENTORY_NOT_EQUIPPED"))){ 
				 int x = Integer.parseInt(splitLine[0]);
					int y = Integer.parseInt(splitLine[1]);
					int dir = Integer.parseInt(splitLine[2]);

					String img = splitLine[3];
					String nameID = splitLine[4];
					String itemtype = splitLine[5];
					double livesLeft, intellect, strength, agility, hardiness, experience, movement, lifeAmount, manaAmount;
					int rank;
					switch (itemtype) {
					case "Wearable":
						// ln(splitLine[7]);
						livesLeft = Double.parseDouble(splitLine[6]);
						intellect = Double.parseDouble(splitLine[7]);
						strength = Double.parseDouble(splitLine[8]);
						agility = Double.parseDouble(splitLine[9]);
						hardiness = Double.parseDouble(splitLine[10]);
						experience = Double.parseDouble(splitLine[11]);
						movement = Double.parseDouble(splitLine[12]);
						lifeAmount = Double.parseDouble(splitLine[13]);
						manaAmount = Double.parseDouble(splitLine[14]);
						String wearableType = splitLine[15];

						WearableItemType wT = null;
						switch (wearableType) {
						case "HELMET":
							wT = WearableItemType.HELMET;
							break;
						case "BOOTS":
							wT = WearableItemType.BOOTS;
							break;
						case "ARMOR":
							wT = WearableItemType.ARMOR;
							break;
						case "WEAPON":
							wT = WearableItemType.WEAPON;
							break;

						}
						rank = Integer.parseInt(splitLine[16]);

						StatBlob wearBlob = new StatBlob(livesLeft, intellect,
								strength, agility, hardiness, experience, movement,
								lifeAmount, manaAmount);
						Position wP = new Position(x, y, Direction.NORTH);
						WearableItem wearableItem = new WearableItem(nameID, img,
								wP, rank, wearBlob, wT);
						armory1.equip(wearableItem);
						break;
					}
					line = input.readLine();
					splitLine = line.split(",");

			 }
			
			 
			 Inventory inv = new Inventory();
				
				line = input.readLine();// skipping items
				// ln(line);
				ArrayList<Item> inventory = new ArrayList<Item>();
				line = input.readLine();
				splitLine = line.split(",");
				while (!splitLine[0].equals("BASE_STATS_WITH_NO_OCCUPATION_NO_EQUIPMENT")) {// check here!!!!!!!!!
					int x = Integer.parseInt(splitLine[0]);
					int y = Integer.parseInt(splitLine[1]);
					int dir = Integer.parseInt(splitLine[2]);

					String img = splitLine[3];
					String nameID = splitLine[4];
					String itemtype = splitLine[5];
					double livesLeft, intellect, strength, agility, hardiness, experience, movement, lifeAmount, manaAmount;
					int rank;
					switch (itemtype) {
					case "OneShotItem":

						livesLeft = Double.parseDouble(splitLine[7]);
						intellect = Double.parseDouble(splitLine[8]);
						strength = Double.parseDouble(splitLine[9]);
						agility = Double.parseDouble(splitLine[10]);
						hardiness = Double.parseDouble(splitLine[11]);
						experience = Double.parseDouble(splitLine[12]);
						movement = Double.parseDouble(splitLine[13]);
						lifeAmount = Double.parseDouble(splitLine[14]);
						manaAmount = Double.parseDouble(splitLine[15]);

						StatBlob blob = new StatBlob(livesLeft, intellect,
								strength, agility, hardiness, experience, movement,
								lifeAmount, manaAmount);
						Position pr = new Position(x, y, Direction.NORTH);
						OneShotItem oneShotItem = new OneShotItem(nameID, img, pr,
								blob);
						inv.addItem(oneShotItem);
						break;
					case "Wearable":
						// ln(splitLine[7]);
						livesLeft = Double.parseDouble(splitLine[6]);
						intellect = Double.parseDouble(splitLine[7]);
						strength = Double.parseDouble(splitLine[8]);
						agility = Double.parseDouble(splitLine[9]);
						hardiness = Double.parseDouble(splitLine[10]);
						experience = Double.parseDouble(splitLine[11]);
						movement = Double.parseDouble(splitLine[12]);
						lifeAmount = Double.parseDouble(splitLine[13]);
						manaAmount = Double.parseDouble(splitLine[14]);
						String wearableType = splitLine[15];

						WearableItemType wT = null;
						switch (wearableType) {
						case "HELMET":
							wT = WearableItemType.HELMET;
							break;
						case "BOOTS":
							wT = WearableItemType.BOOTS;
							break;
						case "ARMOR":
							wT = WearableItemType.ARMOR;
							break;
						case "WEAPON":
							wT = WearableItemType.WEAPON;
							break;

						}
						rank = Integer.parseInt(splitLine[16]);

						StatBlob wearBlob = new StatBlob(livesLeft, intellect,
								strength, agility, hardiness, experience, movement,
								lifeAmount, manaAmount);
						Position wP = new Position(x, y, Direction.NORTH);
						WearableItem wearableItem = new WearableItem(nameID, img,
								wP, rank, wearBlob, wT);
						inv.addItem(wearableItem);
						break;
					case "ObstacleItem":
						Position oP = new Position(x, y, Direction.NORTH);
						ObstacleItem obstacleItem = new ObstacleItem(nameID, img,
								oP);
						inv.addItem(obstacleItem);
						break;
					case "Takeable":
						Position tP = new Position(x, y, Direction.NORTH);
						TakeableItem takeableItem = new TakeableItem(nameID, img,
								tP);
						inv.addItem(takeableItem);
					default:
						break;
					}
					line = input.readLine();
					splitLine = line.split(",");
				}
			
			
			
			
	
			line = input.readLine();
			splitLine = line.split(",");

			double livesLeft, intellect, strength, agility, hardiness, experience, movement, lifeAmount, manaAmount;

			livesLeft = Double.parseDouble(splitLine[0]);
			intellect = Double.parseDouble(splitLine[1]);
			strength = Double.parseDouble(splitLine[2]);
			agility = Double.parseDouble(splitLine[3]);
			hardiness = Double.parseDouble(splitLine[4]);
			experience = Double.parseDouble(splitLine[5]);
			movement = Double.parseDouble(splitLine[6]);
			lifeAmount = Double.parseDouble(splitLine[7]);
			manaAmount = Double.parseDouble(splitLine[8]);

			StatBlob wearBlob = new StatBlob(livesLeft, intellect, strength,
					agility, hardiness, experience, movement, lifeAmount,
					manaAmount);
			

			//StatCollection sc = new StatCollection(armory1,wearBlob);
			
			Entity av = new Entity("avatar", image, p, isFlying);
			av.setInventory(inv);
			//av.setStatCollection(sc);
			switch(occupation){
			case("Smasher"):
				av.changeOccupation(new Smasher());
			case("Sneak"):
				av.changeOccupation(new Sneak());
			case("Summoner"):
				av.changeOccupation(new Summoner());
			}
			
			
			line = input.readLine();

			
			
			 return av;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}
}
