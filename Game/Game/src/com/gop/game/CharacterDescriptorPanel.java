package com.gop.game;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDescriptorPanel extends JPanel {

	private static final long serialVersionUID = -1921226467962871513L;

	private ICharacterDescriptor characterDescriptor;

	private JPanel panelIdentity;
	private JLabel labelIdentityName;
	private JLabel labelIdentityGender;
	private JLabel labelIdentityRace;

	public CharacterDescriptorPanel(ICharacterDescriptor characterDescriptor) {
		this.characterDescriptor = characterDescriptor;
		createElements();
		preparePanelIdentity();
	}

	private void createElements() {
		panelIdentity = new JPanel();
		labelIdentityName = new JLabel();
		labelIdentityGender = new JLabel();
		labelIdentityRace = new JLabel();

	}

	private void preparePanelIdentity() {
		panelIdentity.setLayout(new GridLayout(1, 3));
		panelIdentity.setBorder(BorderFactory.createTitledBorder("Identity :"));

		labelIdentityName.setText(characterDescriptor.getNameForDisplay());
		labelIdentityGender.setText(characterDescriptor.getGenderForDisplay());
		labelIdentityRace.setText(characterDescriptor.getRaceForDisplay());

		panelIdentity.add(labelIdentityName);
		panelIdentity.add(labelIdentityGender);
		panelIdentity.add(labelIdentityRace);
		this.add(panelIdentity);
	}

	public static void main(String[] argv) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		ICharacterDescriptor characterDescriptor = new ICharacterDescriptor() {
			@Override
			public String getXpForDisplay() {
				return "13540";
			}

			@Override
			public String getRaceForDisplay() {
				return "HUMAN";
			}

			@Override
			public String getNameForDisplay() {
				return "Marcel";
			}

			@Override
			public String getMPForDisplay() {
				return "500";
			}

			@Override
			public String getLevelForDisplay() {
				return "14";
			}

			@Override
			public String getHPForDisplay() {
				return "150";
			}

			@Override
			public String getGenderForDisplay() {
				return "Male";
			}
		};

		UIManager.setLookAndFeel(UIManager
				.getCrossPlatformLookAndFeelClassName());
		JFrame frame = new JFrame();
		frame.setSize(800, 400);
		frame.setTitle("CharacterDescriptorPanel Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		CharacterDescriptorPanel characterDescriptorPanel = new CharacterDescriptorPanel(
				characterDescriptor);
		frame.add(characterDescriptorPanel);

		frame.setVisible(true);
	}
}
