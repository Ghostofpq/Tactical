package com.gop.engine.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Characteristics {
	private int strength;
	private int endurance;
	private int intelligence;
	private int will;
	private int agility;
	private int movement;

	public Characteristics(int strength, int endurance, int intelligence,
			int will, int agility, int movement) {
		this.setStrength(strength);
		this.setEndurance(endurance);
		this.setIntelligence(intelligence);
		this.setWill(will);
		this.setAgility(agility);
		this.setMovement(movement);
	}

	public void plus(Characteristics characteristics) {
		this.setStrength(this.getStrength() + characteristics.getStrength());
		this.setEndurance(this.getEndurance() + characteristics.getEndurance());
		this.setIntelligence(this.getIntelligence()
				+ characteristics.getIntelligence());
		this.setWill(this.getWill() + characteristics.getWill());
		this.setAgility(this.getAgility() + characteristics.getAgility());
		this.setMovement(this.getMovement() + characteristics.getMovement());
	}
}
