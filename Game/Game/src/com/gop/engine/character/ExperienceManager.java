package com.gop.engine.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExperienceManager {

	private final int DEFAULT_START_LEVEL = 1;
	private final double DEFAULT_START_XP = 0;
	private final double DEFAULT_START_NEXT_LEVEL = 250;
	
	/**
	 * Level
	 */
	private int level;
	/**
	 * Current experience
	 */
	private double experience;
	/**
	 * Experience goal for the next level
	 */
	private double nextLevel;

	/**
	 * Creates a new ExperienceManager
	 */
	public ExperienceManager() {
		super();
		this.level = DEFAULT_START_LEVEL;
		this.experience = DEFAULT_START_XP;
		this.nextLevel = DEFAULT_START_NEXT_LEVEL;
	}

	/**
	 * Creates a new ExperienceManager with manually set start values
	 *  
	 * @param {@link Integer} level
	 * @param {@link Double} experience
	 * @param {@link Double} nextLevel
	 */
	public ExperienceManager(int level, double experience, double nextLevel) {
		super();
		this.level = level;
		this.experience = experience;
		this.nextLevel = nextLevel;
	}
	
	public void gainXp(double experience) {
		this.experience += experience;
	}

	private boolean canLevelUp() {
		return (experience >= nextLevel);
	}

	private void levelUp() {
		this.level++;
		this.calculateNextLevel();
	}

	private void calculateNextLevel() {
		double coef = (1 / (Math.sqrt(this.level)));
		this.nextLevel = Math.floor(coef * this.nextLevel);
	}
}
