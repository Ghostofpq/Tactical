package com.gop.game;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = -3240976908707553886L;
	private GlobalGameData globalGameData;
	private PlayerSelector playerSelector;
	private JPanel testouille;

	public MainMenu() throws IOException {
		this.setSize(1000, 800);
		this.setTitle("Throne of Seltyr");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		globalGameData = new GlobalGameData();
		playerSelector = new PlayerSelector(this, globalGameData);
		this.add(playerSelector);
		this.setVisible(true);
	}

	public void closePlayerSelectionPanel() {
		this.remove(playerSelector);
		testouille.setToolTipText(globalGameData.getPlayer().getName());
		this.add(testouille);
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
