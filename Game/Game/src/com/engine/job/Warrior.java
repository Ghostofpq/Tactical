package com.engine.job;

import java.util.ArrayList;
import java.util.List;

import com.gop.engine.character.Caracteristics;

public class Warrior extends T_Job {

	private final static String WARRIOR_NAME = "Warrior";
	private final static String WARRIOR_DESC = "Warriors are stronk";

	public Warrior() {
		super(WARRIOR_NAME, WARRIOR_DESC);
		this.prepareSkillTree();
	}

	// Warrior Skills
	private void prepareSkillTree() {
		List<T_Capacity> skillTree = new ArrayList<T_Capacity>();

		Caracteristics strength1C = new Caracteristics(5, 0, 0, 0, 0);
		Amelioration strength1 = new Amelioration("strength1",
				"strength1 desc", strength1C, 50);
		skillTree.add(strength1);

		Caracteristics strength2C = new Caracteristics(10, 0, 0, 0, 0);
		Amelioration strength2 = new Amelioration("strength2",
				"strength2 desc", strength2C, 150);
		skillTree.add(strength2);

		Caracteristics strength3C = new Caracteristics(20, 0, 0, 0, 0);
		Amelioration strength3 = new Amelioration("strength3",
				"strength3 desc", strength3C, 500);
		skillTree.add(strength3);

		Caracteristics endurance1C = new Caracteristics(0, 5, 0, 0, 0);
		Amelioration endurance1 = new Amelioration("endurance1",
				"endurance1 desc", endurance1C, 50);
		skillTree.add(endurance1);

		Caracteristics endurance2C = new Caracteristics(0, 10, 0, 0, 0);
		Amelioration endurance2 = new Amelioration("endurance2",
				"endurance2 desc", endurance2C, 150);
		skillTree.add(endurance2);
		Caracteristics endurance3C = new Caracteristics(0, 20, 0, 0, 0);
		Amelioration endurance3 = new Amelioration("endurance3",
				"endurance3 desc", endurance3C, 500);
		skillTree.add(endurance3);

		strength2.addPrerequisites(strength1);
		strength3.addPrerequisites(strength2);
		endurance2.addPrerequisites(endurance1);
		endurance3.addPrerequisites(endurance2);

		this.setSkillTree(skillTree);
	}
}
