package com.gop.engine.race;

import com.gop.engine.character.Caracteristics;

public class Human extends T_Race {
	private final String HUMAN_NAME = "Human";
	private final String HUMAN_DESCRIPTION = "blablablabla HUMANZZZZ!!";

	private final int HUMAN_BASE_STRENGTH = 10;
	private final int HUMAN_BASE_ENDURANCE = 10;
	private final int HUMAN_BASE_INTELLIGENCE = 10;
	private final int HUMAN_BASE_WILL = 10;
	private final int HUMAN_BASE_AGILITY = 10;

	private final int HUMAN_LVL_STRENGTH = 2;
	private final int HUMAN_LVL_ENDURANCE = 2;
	private final int HUMAN_LVL_INTELLIGENCE = 2;
	private final int HUMAN_LVL_WILL = 2;
	private final int HUMAN_LVL_AGILITY = 2;

	public Human() {
		this.setName(HUMAN_NAME);
		this.setDescription(HUMAN_DESCRIPTION);
		this.setRace(E_Race.HUMAN);
		this.setBaseCaracteristics(new Caracteristics(HUMAN_BASE_STRENGTH,
				HUMAN_BASE_ENDURANCE, HUMAN_BASE_INTELLIGENCE, HUMAN_BASE_WILL,
				HUMAN_BASE_AGILITY));
		this.setLevelUpCaracteristics(new Caracteristics(HUMAN_LVL_STRENGTH,
				HUMAN_LVL_ENDURANCE, HUMAN_LVL_INTELLIGENCE, HUMAN_LVL_WILL,
				HUMAN_LVL_AGILITY));
	}
}
