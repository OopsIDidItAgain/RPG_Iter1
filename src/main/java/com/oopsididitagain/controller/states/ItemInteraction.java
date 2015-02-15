package com.oopsididitagain.controller.states;

import com.oopsididitagain.gui.View;
import com.oopsididitagain.model.Entity;

public interface ItemInteraction {
	void accept(Entity visitor);
}
