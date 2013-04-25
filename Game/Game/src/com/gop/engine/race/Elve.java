package com.gop.engine.race;

import com.gop.engine.character.Caracteristics;

public class Elve extends T_Race {
	private final String ELVE_NAME = "Human";
	private final String ELVE_DESCRIPTION = "blablablabla ELVEZZZZ!!";

	private final int ELVE_BASE_STRENGTH = 8;
	private final int ELVE_BASE_ENDURANCE = 8;
	private final int ELVE_BASE_INTELLIGENCE = 12;
	private final int ELVE_BASE_WILL = 11;
	private final int ELVE_BASE_AGILITY = 11;

	private final int ELVE_LVL_STRENGTH = 1;
	private final int ELVE_LVL_ENDURANCE = 1;
	private final int ELVE_LVL_INTELLIGENCE = 3;
	private final int ELVE_LVL_WILL = 2;
	private final int ELVE_LVL_AGILITY = 3;

	public Elve() {
		this.setName(ELVE_NAME);
		this.setDescription(ELVE_DESCRIPTION);
		this.setRace(E_Race.ELVE);
		this.setBaseCaracteristics(new Caracteristics(ELVE_BASE_STRENGTH,
				ELVE_BASE_ENDURANCE, ELVE_BASE_INTELLIGENCE, ELVE_BASE_WILL,
				ELVE_BASE_AGILITY));
		this.setLevelUpCaracteristics(new Caracteristics(ELVE_LVL_STRENGTH,
				ELVE_LVL_ENDURANCE, ELVE_LVL_INTELLIGENCE, ELVE_LVL_WILL,
				ELVE_LVL_AGILITY));
	}
}