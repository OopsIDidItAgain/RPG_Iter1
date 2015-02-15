package com.oopsididitagain.controller.states;

import com.oopsididitagain.gui.InventoryViewport;
import com.oopsididitagain.model.Entity;

public interface ItemInteraction {
	void accept(Entity visitor);
	void accept(InventoryViewport inventoryViewport);
}
