package com.gop.engine.character;

import com.gop.engine.race.E_Race;
import com.gop.engine.race.T_Race;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCharacter {
	public enum Gender {
		Male, Female
	}

	private Caracteristics caracteristics;

	// Identity
	private String name;
	private String story;
	private T_Race race;
	private Gender gender;

	// XP
	private int level;
	private double experience;
	private double nextLevel;

	public NewCharacter(String name, E_Race race, Gender gender) {
		this.name = name;
		this.race = T_Race.Race(race);
		this.gender = gender;
		this.caracteristics = this.race.getBaseCaracteristics();

		this.level = 1;
		this.experience = 0;
		this.nextLevel = 250;
	}

	public boolean canLvlUp() {
		return (experience >= nextLevel);
	}

	public void levelUp() {
		this.level++;
		this.calculateNext(this.level, this.nextLevel);
		this.caracteristics.plus(this.race.getLevelUpCaracteristics());
	}

	private void calculateNext(int level, double nextLevel) {
		double coef = ((Math.sqrt(experience)) / experience);
		nextLevel = Math.floor(coef * experience);
	}

}
