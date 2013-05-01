package com.gop.engine.race;

import com.gop.engine.characteristics.PrimaryCharacteristics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class T_Race {
	private E_Race race;
	private PrimaryCharacteristics baseCaracteristics;
	private PrimaryCharacteristics levelUpCaracteristics;

	private String description;
	private String name;

	public static T_Race Race(E_Race race) {
		switch (race) {
		case ELVE:
			return new Elve();
		case HUMAN:
			return new Human();
		case DWARF:
			return new Dwarf();
		default:
			return null;
		}
	}
}
