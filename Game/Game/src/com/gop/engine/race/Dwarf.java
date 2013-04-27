package com.gop.engine.race;

import com.gop.engine.character.Caracteristics;

public class Dwarf extends T_Race {
	private final String DWARF_NAME = "Dwarf";
	private final String DWARF_DESCRIPTION = "blablablabla DWARFFFFF!!";

	private final int DWARF_BASE_STRENGTH = 11;
	private final int DWARF_BASE_ENDURANCE = 13;
	private final int DWARF_BASE_INTELLIGENCE = 8;
	private final int DWARF_BASE_WILL = 9;
	private final int DWARF_BASE_AGILITY = 9;
	private final int DWARF_BASE_MOVEMENT = 2;

	private final int DWARF_LVL_STRENGTH = 3;
	private final int DWARF_LVL_ENDURANCE = 3;
	private final int DWARF_LVL_INTELLIGENCE = 1;
	private final int DWARF_LVL_WILL = 2;
	private final int DWARF_LVL_AGILITY = 1;
	private final int DWARF_LVL_MOVEMENT = 0;

	public Dwarf() {
		this.setName(DWARF_NAME);
		this.setDescription(DWARF_DESCRIPTION);
		this.setRace(E_Race.DWARF);
		this.setBaseCaracteristics(new Caracteristics(DWARF_BASE_STRENGTH,
				DWARF_BASE_ENDURANCE, DWARF_BASE_INTELLIGENCE, DWARF_BASE_WILL,
				DWARF_BASE_AGILITY, DWARF_BASE_MOVEMENT));
		this.setLevelUpCaracteristics(new Caracteristics(DWARF_LVL_STRENGTH,
				DWARF_LVL_ENDURANCE, DWARF_LVL_INTELLIGENCE, DWARF_LVL_WILL,
				DWARF_LVL_AGILITY, DWARF_LVL_MOVEMENT));
	}
}
