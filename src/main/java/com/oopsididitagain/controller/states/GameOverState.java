package com.oopsididitagain.controller.states;

import java.io.File;

import javax.swing.JFileChooser;

import com.oopsididitagain.controller.Controller;
import com.oopsididitagain.controller.GameOverController;
import com.oopsididitagain.gui.View;
//import com.oopsididitagain.controller.GameOverState;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.util.CSVTool;

public class GameOverState extends GameState {

	private static GameOverState instance;
	private Entity avatar;
	private GameMap map;

	private GameOverState() {
	}

	public void setAvatar(Entity avatar) {
		 	this.avatar = avatar;
	}

	public void setMap(GameMap map) {
			this.map = map;
	}

	public static GameState getInstance() {
		if (instance == null) {
			instance = new GameOverState();
		}
		return instance;
	}

	public String toString() {
		return "GameOverState";
	}

	@Override
	public Controller getController() {
		return GameOverController.getInstance();
	}

	@Override
	public void accept(View visitor) {
		visitor.visit(this);
	}

	

	}
