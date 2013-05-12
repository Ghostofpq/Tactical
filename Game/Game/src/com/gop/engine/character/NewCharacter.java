package com.gop.engine.character;

import com.gop.engine.character.Identity.Gender;
import com.gop.engine.characteristics.PrimaryCharacteristics;
import com.gop.engine.characteristics.SecondaryCharacteristics;
import com.gop.engine.job.T_Job;
import com.gop.engine.job.Warrior;
import com.gop.engine.race.E_Race;
import com.gop.engine.race.T_Race;

import lombok.Getter;
import lombok.Setter;

/**
 * Representation of a character. It determines <br/>
 * -its identity with a name, a background story, a race and a gender <br/>
 * -its evolution with level, experience and next level cap <br/>
 * -its learnings through different job paths <br/>
 * 
 * -its data descriptions via characteristics, life and mana points <br/>
 * 
 * @author GhostOfPQ
 * 
 */
@Getter
@Setter
public class NewCharacter {

	// Identity
	/**
	 * Identity of the character
	 */
	private Identity identity;
	/**
	 * Background story of the character
	 */
	private String story;

	// Evolution
	private final int DEFAULT_START_LEVEL = 1;
	private final double DEFAULT_START_XP = 0;
	private final double DEFAULT_START_NEXT_LEVEL = 250;
	/**
	 * Level of the character
	 */
	private int level;
	/**
	 * Current experience of the character
	 */
	private double experience;
	/**
	 * Experience goal for the next level
	 */
	private double nextLevel;

	// Learnings
	/**
	 * Current {@link T_Job} of the character
	 */
	private T_Job currentJob;
	/**
	 * {@link Warrior} path of the character
	 */
	private Warrior jobWarrior;

	// Caracteristics
	/**
	 * {@link PrimaryCharacteristics} of the character acquired by leveling
	 */
	private PrimaryCharacteristics characteristics;
	/**
	 * {@link SecondaryCharacteristics} of the character acquired by calculation
	 * from leveling
	 */
	private SecondaryCharacteristics secondaryCharacteristics;

	/**
	 * Aggregated {@link PrimaryCharacteristics} of the character (with job and
	 * equipement)
	 */
	private PrimaryCharacteristics aggregatedCharacteristics;
	/**
	 * Aggregated {@link SecondaryCharacteristics} of the character (with job and
	 * equipement)
	 */
	private SecondaryCharacteristics aggregatedSecondaryCharacteristics;

	/**
	 * Life point of the character
	 */
	private int lifePoint;
	/**
	 * Mana point of the character
	 */
	private int manaPoint;

	/**
	 * Creates a new Character level 1 Warrior.
	 * 
	 * @param name
	 *            name of the character
	 * @param race
	 *            {@link E_Race} of the character
	 * @param gender
	 *            {@link Gender} of the character
	 */
	public NewCharacter(String name, E_Race race, Gender gender) {
		// Identity
		this.identity = new Identity(name, T_Race.Race(race), gender);

		// XP
		this.level = DEFAULT_START_LEVEL;
		this.experience = DEFAULT_START_XP;
		this.nextLevel = DEFAULT_START_NEXT_LEVEL;

		// Jobs
		this.jobWarrior = new Warrior();
		this.currentJob = this.jobWarrior;

		// Caracteristics
		this.characteristics = this.getIdentity().getRace()
				.getBaseCaracteristics();
		this.aggregatedCharacteristics = new PrimaryCharacteristics(0, 0, 0, 0,
				0, 0);
		

		updateLifeAndManaPoint();
	}

	public void gainXp(double experience) {
		this.experience += experience;
		while (canLevelUp()) {
			levelUp();
		}
	}

	private boolean canLevelUp() {
		return (experience >= nextLevel);
	}

	private void levelUp() {
		this.level++;
		this.calculateNextLevel();
		this.characteristics.plus(this.getIdentity().getRace()
				.getLevelUpCaracteristics());

		updateLifeAndManaPoint();
	}

	private void calculateNextLevel() {
		double coef = (1 / (Math.sqrt(this.level)));
		this.nextLevel = Math.floor(coef * this.nextLevel);
	}

	private void updateLifeAndManaPoint() {
		calculateAggregatedCaracteristics();
		this.lifePoint = this.aggregatedCharacteristics.getEndurance() * 10;
		this.manaPoint = this.aggregatedCharacteristics.getIntelligence() * 10;
	}

	private PrimaryCharacteristics getBonusFromJobs() {
		PrimaryCharacteristics result = new PrimaryCharacteristics(0, 0, 0, 0,
				0, 0);
		result.plus(this.jobWarrior.getAggregatedCaracteristics());
		return result;
	}

	private PrimaryCharacteristics getBonusFromEquipement() {
		PrimaryCharacteristics result = new PrimaryCharacteristics(0, 0, 0, 0,
				0, 0);

		return result;
	}

	private void calculateAggregatedCaracteristics() {
		this.aggregatedCharacteristics = this.characteristics;
		this.aggregatedCharacteristics.plus(getBonusFromJobs());
		this.aggregatedCharacteristics.plus(getBonusFromEquipement());
	}
}
