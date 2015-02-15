package com.oopsididitagain.gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.oopsididitagain.controller.states.AvatarCreationGameState;
import com.oopsididitagain.controller.states.ExitGameState;
import com.oopsididitagain.controller.states.GameState;
import com.oopsididitagain.controller.states.InventoryGameState;
import com.oopsididitagain.controller.states.PauseGameState;
import com.oopsididitagain.controller.states.PlayGameState;
import com.oopsididitagain.controller.states.StartGameState;
import com.oopsididitagain.menu.AvatarCreationMenu;
import com.oopsididitagain.menu.InventoryMenu;
import com.oopsididitagain.menu.PauseMenu;
import com.oopsididitagain.model.Entity;
import com.oopsididitagain.model.GameMap;
import com.oopsididitagain.model.Inventory;

public class View extends JPanel {

	private static final long serialVersionUID = 8740227504423945127L;
	private StartGameViewport startGameViewport;
	private AreaViewport areaViewport;
	private StatsViewport statsViewport;
	private PauseViewPort pauseViewPort;
	private boolean paused;
	private String currentGameState = "";
	private InventoryViewport InventoryViewport;
	private AvatarCreationViewport AvatarCreationViewport;

	public View(AreaViewport areaViewport, StatsViewport statsViewport) {
		super();
		setFocusable(true);
		this.areaViewport = areaViewport;
		this.statsViewport = statsViewport;
	}

	public View() {
		super();
		setFocusable(true);

	}

	public void setAreaViewport(AreaViewport areaViewport) {
		this.areaViewport = areaViewport;
	}

	public void setStatsViewport(StatsViewport statsViewport) {
		this.statsViewport = statsViewport;
	}

	public void render(GameState state) {
		state.accept(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentGameState == "StartGameState") {
			super.paintComponent(g);
			startGameViewport.displayStartMenu(g);
		} else if (currentGameState == "PlayGameState") {
			super.paintComponent(g);
			areaViewport.displayMap(g);
			statsViewport.displayStats(g);

		} else if (currentGameState == "PauseGameState") {
			super.paintComponent(g);
			areaViewport.displayMap(g);
			statsViewport.displayStats(g);
			PauseViewPort.displayPauseMenu(g);
		} else if (currentGameState == "InventoryGameState") {
			super.paintComponent(g);
			areaViewport.displayMap(g);
			statsViewport.displayStats(g);
			InventoryViewport.displayInventoryMenu(g);
		} else if (currentGameState == "AvatarCreationGameState") {
			super.paintComponent(g);
			AvatarCreationViewport.displayAvatarCreation(g);
		}

	}

	public void visit(ExitGameState exitGameState) {
		// TODO Auto-generated method stub

	}

	public void visit(InventoryGameState inventoryGameState) {
		if (inventoryGameState.toString() == currentGameState) {
			this.repaint();
		} else {
			currentGameState = inventoryGameState.toString();
			paused = true;
			InventoryMenu im = inventoryGameState.getInventoryMenu();
			Inventory inventory = inventoryGameState.getInventory();
			this.InventoryViewport = new InventoryViewport(im, inventory);
			this.repaint();
		}

	}

	public void visit(AvatarCreationGameState avatarCreateGameState) {
		if (avatarCreateGameState.toString() == currentGameState) {
			this.repaint();
		} else {
			currentGameState = avatarCreateGameState.toString();
			paused = true;
			AvatarCreationMenu am = avatarCreateGameState
					.getAvatarCreationMenu();
			this.AvatarCreationViewport = new AvatarCreationViewport(am);
			this.repaint();
		}

	}

	public void visit(PauseGameState pauseGameState) {
		if (pauseGameState.toString() == currentGameState) {
			this.repaint();
		} else {
			currentGameState = pauseGameState.toString();
			paused = true;
			PauseMenu pm = pauseGameState.getPauseMenu();
			this.pauseViewPort = new PauseViewPort(pm);
			this.repaint();
		}

	}

	public void visit(PlayGameState playGameState) {
		if (playGameState.toString() == currentGameState) {
			this.repaint();
		} else {
			currentGameState = playGameState.toString();
			paused = false;
			GameMap map = playGameState.getGameMap();
			Entity avatar = playGameState.getAvatar();
			this.areaViewport = new AreaViewport(map, avatar);
			this.statsViewport = new StatsViewport(avatar);
			this.repaint();
		}

	}

	public void visit(StartGameState startGameState) {
		if (startGameState.toString() == currentGameState) {
			this.repaint();
		} else {
			currentGameState = startGameState.toString();
			paused = false;
			this.startGameViewport = new StartGameViewport(startGameState.getStartMenu());
			this.repaint();
		}
	}

}
