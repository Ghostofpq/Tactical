package com.gop.engine.race;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.characteristics.PrimaryCharacteristics;

@Getter
@Setter
public abstract class T_Race implements Serializable {

	private static final long serialVersionUID = -3933914420338387526L;

	public enum E_Race {
		ELVE("Elve"), DWARF("Dwarf"), HUMAN("Human");

		private final String propertyName;

		E_Race(String propertyName) {
			this.propertyName = propertyName;
		}

		@Override
		public String toString() {
			return propertyName;
		}
	}

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
