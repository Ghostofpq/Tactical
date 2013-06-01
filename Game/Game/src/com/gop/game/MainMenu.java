package com.gop.game;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = -3240976908707553886L;

	List<String> players = new ArrayList<String>();

	public MainMenu() throws IOException {
		this.setSize(1000, 800);
		this.setTitle("Throne of Seltyr");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.checkFolderForPlayers();

		this.setVisible(true);
	}

	public boolean createPlayer(String playerName) throws IOException {
		File gameFile = new File("./saves/" + playerName);
		return gameFile.createNewFile();
	}

	public void checkFolderForPlayers() throws IOException {
		File gameFile = new File("./saves/");
		if (!gameFile.exists()) {
			gameFile.mkdir();
		} else {
			players = Arrays.asList(gameFile.list());
		}
	}

	public static void main(String[] argv) throws IOException {

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager
					.getCrossPlatformLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		MainMenu menu = new MainMenu();
	}
}
