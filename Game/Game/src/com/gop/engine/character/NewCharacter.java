package com.gop.engine.character;

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
	/**
	 * Female or Male
	 */
	public enum Gender {
		FEMALE, MALE
	}

	// Identity
	/**
	 * Name of the character
	 */
	private String name;
	/**
	 * Background story of the character
	 */
	private String story;
	/**
	 * {@link T_Race} of the Character
	 */
	private T_Race race;
	/**
	 * {@link Gender} of the Character
	 */
	private Gender gender;

	// Evolution
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
	 * {@link Characteristics} of the character acquired by leveling
	 */
	private Characteristics characteristics;
	/**
	 * Aggregated {@link Characteristics} of the character (with job and
	 * equipement)
	 */
	private Characteristics aggregatedCharacteristics;
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
		this.name = name;
		this.race = T_Race.Race(race);
		this.gender = gender;

		// XP
		this.level = 1;
		this.experience = 0;
		this.nextLevel = 250;

		// Jobs
		this.jobWarrior = new Warrior();
		this.currentJob = this.jobWarrior;

		// Caracteristics
		this.characteristics = this.race.getBaseCaracteristics();
		this.aggregatedCharacteristics = new Characteristics(0, 0, 0, 0, 0, 0);

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
		this.characteristics.plus(this.race.getLevelUpCaracteristics());

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

	private Characteristics getBonusFromJobs() {
		Characteristics result = new Characteristics(0, 0, 0, 0, 0, 0);
		result.plus(this.jobWarrior.getAggregatedCaracteristics());
		return result;
	}

	private Characteristics getBonusFromEquipement() {
		Characteristics result = new Characteristics(0, 0, 0, 0, 0, 0);

		return result;
	}

	private void calculateAggregatedCaracteristics() {
		this.aggregatedCharacteristics = this.characteristics;
		this.aggregatedCharacteristics.plus(getBonusFromJobs());
		this.aggregatedCharacteristics.plus(getBonusFromEquipement());
	}
}
