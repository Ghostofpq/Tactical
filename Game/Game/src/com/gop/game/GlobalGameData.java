package com.gop.game;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.Player;

@Getter
@Setter
public class GlobalGameData {

	public enum GameState {
		PLAYER_SELECT
	}

	private Player player;
	private String playerToCreateName;

	private GameState gameState;

}
