package com.oopsididitagain.controller.states;

import com.oopsididitagain.gui.View;

public interface StateRenderElement {
	void accept(View visitor);
}
