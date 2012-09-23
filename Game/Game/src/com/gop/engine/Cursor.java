package com.gop.engine;

import com.gop.graphics.DisplayManager;

public class Cursor {
	private int posX;
	private int posY;
	Map map;
	DisplayManager dm;

	public Cursor(Map map, DisplayManager dm) {
		this.posX = 0;
		this.posY = 0;
		this.map = map;
		this.dm = dm;
	}

	public int getposX() {
		return posX;
	}

	public int getposY() {
		return posY;
	}

	public void focusOn(int X, int Y) {
		CleanHighlight();
		posX = X;
		posY = Y;
		HighlightCurrentTile();
	}

	private void CleanHighlight() {
		map.getTile(posX, posY).setHighlighted(false);
	}

	private void HighlightCurrentTile() {
		map.getTile(posX, posY).setHighlighted(true);
	}

	public void goUp() {
		CleanHighlight();
		switch (dm.getGameBoard().getCurrentView()) {
		case South:
			if (posX > 0) {
				posX--;
			}
			break;
		case West:
			if (posY < map.getWidth() - 1) {
				posY++;
			}
			break;
		case North:
			if (posX < map.getLength() - 1) {
				posX++;
			}
			break;
		case East:
			if (posY > 0) {
				posY--;
			}
			break;
		}
		HighlightCurrentTile();
	}

	public void goDown() {
		CleanHighlight();
		switch (dm.getGameBoard().getCurrentView()) {
		case South:
			if (posX < map.getLength() - 1) {
				posX++;
			}
			break;
		case West:
			if (posY > 0) {
				posY--;
			}
			break;
		case North:
			if (posX > 0) {
				posX--;
			}
			break;
		case East:
			if (posY < map.getWidth() - 1) {
				posY++;
			}
			break;
		}
		HighlightCurrentTile();
	}

	public void goLeft() {
		CleanHighlight();
		switch (dm.getGameBoard().getCurrentView()) {
		case South:
			if (posY > 0) {
				posY--;
			}
			break;
		case West:
			if (posX > 0) {
				posX--;
			}
			break;
		case North:
			if (posY < map.getWidth() - 1) {
				posY++;
			}
			break;
		case East:
			if (posX < map.getLength() - 1) {
				posX++;
			}
			break;
		}
		HighlightCurrentTile();
	}

	public void goRigth() {
		CleanHighlight();
		switch (dm.getGameBoard().getCurrentView()) {
		case South:
			if (posY < map.getWidth() - 1) {
				posY++;
			}
			break;
		case West:
			if (posX < map.getLength() - 1) {
				posX++;
			}
			break;
		case North:
			if (posY > 0) {
				posY--;
			}
			break;
		case East:
			if (posX > 0) {
				posX--;
			}
			break;
		}
		HighlightCurrentTile();
	}

}
