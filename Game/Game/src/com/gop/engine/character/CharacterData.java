package com.gop.engine.character;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.characteristics.PrimaryCharacteristics;
import com.gop.engine.characteristics.SecondaryCharacteristics;
import com.gop.engine.job.T_Job;
import com.gop.engine.job.Warrior;
import com.gop.engine.race.T_Race;
import com.gop.engine.race.T_Race.E_Race;
import com.gop.game.ICharacterDescriptor;

/**
 * Representation of a character. It determines <br/>
 * -its identity with a name, a background story, a race and a gender <br/>
 * -its evolution with level, experience and next level cap <br/>
 * -its learnings through different job paths <br/>
 * -its data descriptions via characteristics, life and mana points <br/>
 * 
 * @author GhostOfPQ
 * 
 */
@Getter
@Setter
public class CharacterData implements Serializable, ICharacterDescriptor {

	private static final long serialVersionUID = -525866701627358223L;

	// Identity
	/**
	 * Male or Female
	 */
	public enum Gender {
		FEMALE("\u2640"), MALE("\u2642");

		private final String propertyName;

		Gender(String propertyName) {
			this.propertyName = propertyName;
		}

		@Override
		public String toString() {
			return propertyName;
		}
	}

	/**
	 * Name
	 */
	private String name;
	/**
	 * {@link T_Race}
	 */
	private T_Race race;
	/**
	 * {@link Gender}
	 */
	private Gender gender;
	/**
	 * Background story of the character
	 */
	private String story;

	// Evolution
	private final int DEFAULT_START_LEVEL = 1;
	private final int DEFAULT_START_XP = 0;
	private final int DEFAULT_START_NEXT_LEVEL = 250;
	/**
	 * Level of the character
	 */
	private int level;
	/**
	 * Current experience of the character
	 */
	private int experience;
	/**
	 * Experience goal for the next level
	 */
	private int nextLevel;

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
	 * Aggregated {@link SecondaryCharacteristics} of the character (with job
	 * and equipement)
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
	public CharacterData(String name, E_Race race, Gender gender) {
		// Identity
		this.name = name;
		this.race = T_Race.Race(race);
		this.gender = gender;

		// XP
		this.level = DEFAULT_START_LEVEL;
		this.experience = DEFAULT_START_XP;
		this.nextLevel = DEFAULT_START_NEXT_LEVEL;

		// Jobs
		this.jobWarrior = new Warrior();
		this.currentJob = this.jobWarrior;

		// Caracteristics
		this.characteristics = this.getRace().getBaseCaracteristics();
		this.aggregatedCharacteristics = new PrimaryCharacteristics(0, 0, 0, 0,
				0, 0);

		updateLifeAndManaPoint();
	}

	public void gainXp(double experience) {
		this.experience += experience;
	}

	public void gainJobpoints(int jobPoints) {
		this.currentJob.gainJobPoints(jobPoints);
	}

	public boolean canLevelUp() {
		return (experience >= nextLevel);
	}

	public void levelUp() {
		this.level++;
		this.calculateNextLevel();
		this.characteristics.plus(this.getRace().getLevelUpCaracteristics());

		updateLifeAndManaPoint();
	}

	private void calculateNextLevel() {
		double coef = (1 / (Math.sqrt(this.level)));
		this.nextLevel = (int) Math.floor(coef * this.nextLevel);
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

	/**
	 * Implementation de ICharacterDescriptor
	 */

	@Override
	public String getNameForDisplay() {
		return this.getName();
	}

	@Override
	public String getRaceForDisplay() {
		return this.getRace().getName();
	}

	@Override
	public String getGenderForDisplay() {
		return this.getGender().toString();
	}

	@Override
	public String getHPForDisplay() {
		return String.valueOf(this.getLifePoint());
	}

	@Override
	public String getMPForDisplay() {
		return String.valueOf(this.getManaPoint());
	}

	@Override
	public String getLevelForDisplay() {
		return String.valueOf(this.getLevel());
	}

	@Override
	public String getCurrentXpForDisplay() {
		return String.valueOf(this.getExperience());
	}

	@Override
	public String getXpNextLvl() {
		return String.valueOf(this.getNextLevel());
	}

	@Override
	public String getPathForPortrait() {
		return "./images/SquireMale.png";
	}

	@Override
	public String getStrenghtForDisplay() {
		return String.valueOf(this.getCharacteristics().getStrength());
	}

	@Override
	public String getEnduranceForDisplay() {
		return String.valueOf(this.getCharacteristics().getEndurance());
	}

	@Override
	public String getIntelligenceForDisplay() {
		return String.valueOf(this.getCharacteristics().getIntelligence());
	}

	@Override
	public String getWillForDisplay() {
		return String.valueOf(this.getCharacteristics().getWill());
	}

	@Override
	public String getAgilityForDisplay() {
		return String.valueOf(this.getCharacteristics().getAgility());
	}

	@Override
	public String getMovementForDisplay() {
		return String.valueOf(this.getCharacteristics().getMovement());
	}

	@Override
	public String getCurrentJobForDisplay() {
		return this.getCurrentJob().getName();
	}

	@Override
	public String getCurrentJobJobPointsForDisplay() {
		return String.valueOf(this.getCurrentJob().getJobPoints());
	}
}
