package com.gop.game;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CharacterDescriptorPanel extends JPanel {

	private static final long serialVersionUID = -1921226467962871513L;

	public static void main(String[] argv) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager
				.getCrossPlatformLookAndFeelClassName());
		JFrame frame = new JFrame();
		frame.setSize(800, 400);
		frame.setTitle("CharacterDescriptorPanel Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
