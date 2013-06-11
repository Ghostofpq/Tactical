package com.gop.game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.Player;

@Getter
@Setter
public class PlayerSelector extends JPanel {
	private GlobalGameData globalGameData;
	private MainMenu mainMenu;

	private static final long serialVersionUID = -5903012132678383658L;

	private JButton buttonCreateNewPlayer = new JButton();
	private JButton buttonLoadPlayer = new JButton();

	List<String> players = new ArrayList<String>();

	public void checkFolderForPlayers() throws IOException {
		File gameFile = new File("./saves/");
		if (!gameFile.exists()) {
			gameFile.mkdir();
		} else {
			players = Arrays.asList(gameFile.list());
		}
		buttonLoadPlayer.setEnabled(!players.isEmpty());
	}

	public boolean createPlayer(String playerName) throws IOException {
		Player player = new Player(playerName, null);
		globalGameData.setPlayer(player);

		File gameFile = new File("./saves/" + playerName);
		return gameFile.createNewFile();
	}

	public PlayerSelector(MainMenu mainMenu, GlobalGameData globalGameData)
			throws IOException {
		this.globalGameData = globalGameData;
		this.mainMenu = mainMenu;

		buttonCreateNewPlayer = new JButton();
		buttonLoadPlayer = new JButton();

		buttonCreateNewPlayer.setText("Create New Player");
		buttonLoadPlayer.setText("Load Player");

		this.setLayout(new GridLayout(2, 1));
		this.add(buttonCreateNewPlayer);
		this.add(buttonLoadPlayer);
		this.setSize(200, 200);

		this.setVisible(true);
		checkFolderForPlayers();

		CreatePlayerListener createPlayerListener = new CreatePlayerListener(
				this);
		buttonCreateNewPlayer.addActionListener(createPlayerListener);

	}

	public class CreatePlayerListener implements ActionListener {
		private PlayerSelector parent;

		public CreatePlayerListener(PlayerSelector parent) {
			this.parent = parent;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String playerName = JOptionPane.showInputDialog(
					"What is your name?", null);
			try {
				parent.createPlayer(playerName);
				parent.checkFolderForPlayers();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
