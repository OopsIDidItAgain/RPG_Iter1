package com.oopsididitagain.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.oopsididitagain.model.Item;
import com.oopsididitagain.model.Position;
import com.oopsididitagain.model.TakeableItem;

public class CSVTool {
	
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
						item = new TakeableItem(name, imageName, position, true);
						break;
					}
					case "Takeable": {
						item = new TakeableItem(name, imageName, position, false);
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

