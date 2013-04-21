package com.gop.engine.character;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Caracteristics {
	private int strength;
	private int endurance;
	private int intelligence;
	private int will;
	private int agility;
	
	public Caracteristics(int strength, int endurance, int intelligence,
			int will, int agility) {
		this.setStrength(strength);
		this.setEndurance(endurance);
		this.setIntelligence(intelligence);
		this.setWill(will);
		this.setAgility(agility);
	}

	public void plus(Caracteristics caracteristics) {
		this.setStrength(this.getStrength() + caracteristics.getStrength());
		this.setEndurance(this.getEndurance() + caracteristics.getEndurance());
		this.setIntelligence(this.getIntelligence() + caracteristics.getIntelligence());
		this.setWill(this.getWill() + caracteristics.getWill());
		this.setAgility(this.getAgility() + caracteristics.getAgility());
	}	
}
