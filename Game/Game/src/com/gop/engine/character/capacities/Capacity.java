package com.gop.engine.character.capacities;

import com.gop.engine.character.Character;

public abstract class Capacity {

	protected static Range range;
	protected static int manaCost;

	public static void Activate(Character activator, Character target) {
		activator.setCurrentManaPoints(activator.getCurrentManaPoints()-manaCost);
	}
}
