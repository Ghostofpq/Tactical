package com.gop.engine.character;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.race.T_Race;

/**
 * Identity defined by a name, a race and a gender
 * 
 * @author GhostOfPQ
 * 
 */
@Getter
@Setter
public class Identity {
	/**
	 * Female or Male
	 */
	public enum Gender {
		FEMALE, MALE
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
	 * Creates a new Identity object
	 * 
	 * @param {@link String} name
	 * @param {@link T_Race} race
	 * @param {@link Gender} gender
	 */
	public Identity(String name, T_Race race, Gender gender) {
		super();
		this.name = name;
		this.race = race;
		this.gender = gender;
	}
}
