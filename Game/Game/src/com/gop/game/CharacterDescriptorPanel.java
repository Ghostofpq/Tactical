package com.gop.game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.gop.engine.character.CharacterData;
import com.gop.engine.character.CharacterData.Gender;
import com.gop.engine.race.T_Race.E_Race;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDescriptorPanel extends JPanel {

	private static final long serialVersionUID = -1921226467962871513L;

	private ICharacterDescriptor characterDescriptor;

	private JPanel panelGlobalDescription;

	private JPanel panelIdentity;
	private JLabel labelIdentityName;
	private JLabel labelIdentityRaceAndGender;

	private JPanel panelHPMPAndXP;

	private JPanel panelHPAndMP;
	private JLabel labelHP;
	private JLabel labelMP;

	private JPanel panelXP;

	private JLabel labelLvL;
	private JLabel labelXP;

	private JPanel panelJob;
	private JLabel labelCurrentJob;
	private JLabel labelCurrentJobJobPoints;

	private JPanel panelPortrait;
	private JLabel labelPortrait;
	private BufferedImage portrait;

	private final int GLOBAL_DESCRIPTION_PANEL_WIDTH = 400;
	private final int GLOBAL_DESCRIPTION_PANEL_HEIGTH = 300;

	public CharacterDescriptorPanel(ICharacterDescriptor characterDescriptor)
			throws IOException {
		this.characterDescriptor = characterDescriptor;

		createElements();
		preparePanelGlobalDescription();
		preparePanelPortrait();

		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.VERTICAL;
		this.add(panelPortrait, c);
		c.gridwidth = GridBagConstraints.REMAINDER;
		this.add(panelGlobalDescription, c);
	}

	private void createElements() throws IOException {
		panelIdentity = new JPanel();
		labelIdentityName = new JLabel();
		labelIdentityRaceAndGender = new JLabel();

		panelHPAndMP = new JPanel();
		labelHP = new JLabel();
		labelMP = new JLabel();

		panelXP = new JPanel();
		labelLvL = new JLabel();
		labelXP = new JLabel();

		panelHPMPAndXP = new JPanel();

		panelGlobalDescription = new JPanel();

		panelJob = new JPanel();
		labelCurrentJob = new JLabel();
		labelCurrentJobJobPoints = new JLabel();

		panelPortrait = new JPanel();
		labelPortrait = new JLabel();
	}

	private void preparePanelIdentity() {
		panelIdentity.setLayout(new GridLayout(1, 2));
		panelIdentity.setBorder(BorderFactory.createTitledBorder("Identity :"));

		labelIdentityName.setText(characterDescriptor.getNameForDisplay());
		labelIdentityRaceAndGender.setText(characterDescriptor
				.getRaceForDisplay()
				+ " "
				+ characterDescriptor.getGenderForDisplay());

		panelIdentity.add(labelIdentityName);
		panelIdentity.add(labelIdentityRaceAndGender);
	}

	private void preparePanelHPMPAndXP() {
		GridLayout layoutHPMPAndXP = new GridLayout(1, 2);
		panelHPMPAndXP.setLayout(layoutHPMPAndXP);
		panelHPMPAndXP.setBorder(BorderFactory
				.createTitledBorder("State Info :"));
		preparePanelXP();
		preparePanelHPAndMP();

		panelHPMPAndXP.add(panelHPAndMP);
		panelHPMPAndXP.add(panelXP);

	}

	private void preparePanelHPAndMP() {
		GridLayout layoutHPAndMP = new GridLayout(2, 1);
		layoutHPAndMP.setVgap(10);
		panelHPAndMP.setLayout(layoutHPAndMP);

		labelHP.setText("HP : " + characterDescriptor.getHPForDisplay());
		labelMP.setText("MP : " + characterDescriptor.getMPForDisplay());

		panelHPAndMP.add(labelHP);
		panelHPAndMP.add(labelMP);
	}

	private void preparePanelXP() {
		GridLayout layoutXP = new GridLayout(2, 1);
		layoutXP.setVgap(10);
		panelXP.setLayout(layoutXP);

		labelLvL.setText("LVL." + characterDescriptor.getLevelForDisplay());
		labelXP.setText(characterDescriptor.getCurrentXpForDisplay() + "/"
				+ characterDescriptor.getXpNextLvl());

		panelXP.add(labelLvL);
		panelXP.add(labelXP);
	}

	private void preparePanelJob() {
		panelJob.setLayout(new GridLayout(1, 2));
		panelJob.setBorder(BorderFactory.createTitledBorder("Current Job :"));

		labelCurrentJob.setText(characterDescriptor.getCurrentJobForDisplay());
		labelCurrentJobJobPoints.setText("JP : "
				+ characterDescriptor.getCurrentJobJobPointsForDisplay());

		panelJob.add(labelCurrentJob);
		panelJob.add(labelCurrentJobJobPoints);
	}

	private void preparePanelGlobalDescription() {
		panelGlobalDescription.setLayout(new GridBagLayout());
		panelGlobalDescription.setBorder(BorderFactory.createEtchedBorder());

		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 200;

		preparePanelIdentity();
		preparePanelHPMPAndXP();
		preparePanelJob();

		panelGlobalDescription.add(panelIdentity, c);
		panelGlobalDescription.add(panelHPMPAndXP, c);
		panelGlobalDescription.add(panelJob, c);

	}

	private void preparePanelPortrait() throws IOException {
		panelPortrait.setBorder(BorderFactory.createEtchedBorder());

		portrait = ImageIO.read(new File(characterDescriptor
				.getPathForPortrait()));
		labelPortrait = new JLabel(new ImageIcon(portrait));

		panelPortrait.add(labelPortrait);
	}

	public static void main(String[] argv) throws IOException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		CharacterData nc1 = new CharacterData("Bobyx", E_Race.HUMAN,
				Gender.MALE);
		CharacterData nc2 = new CharacterData("Marcel", E_Race.DWARF,
				Gender.MALE);
		CharacterData nc3 = new CharacterData("Bonny", E_Race.ELVE,
				Gender.FEMALE);

		UIManager.setLookAndFeel(UIManager
				.getCrossPlatformLookAndFeelClassName());
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		frame.setTitle("CharacterDescriptorPanel Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JPanel testpanel = new JPanel();
		testpanel.setLayout(new GridLayout(4, 1));

		CharacterDescriptorPanel characterDescriptorPanel1 = new CharacterDescriptorPanel(
				nc1);
		CharacterDescriptorPanel characterDescriptorPanel2 = new CharacterDescriptorPanel(
				nc2);
		CharacterDescriptorPanel characterDescriptorPanel3 = new CharacterDescriptorPanel(
				nc3);
		CharacterDescriptorPanel characterDescriptorPanel4 = new CharacterDescriptorPanel(
				nc1);

		testpanel.add(characterDescriptorPanel1);
		testpanel.add(characterDescriptorPanel2);
		testpanel.add(characterDescriptorPanel3);
		testpanel.add(characterDescriptorPanel4);

		frame.add(testpanel);
		frame.setVisible(true);
	}
}
