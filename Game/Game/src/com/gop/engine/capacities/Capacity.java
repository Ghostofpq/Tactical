package com.gop.engine.capacities;

import com.gop.engine.Character;
import com.gop.engine.Range;

public abstract class Capacity {

	protected static Range range;
	protected static int manaCost;

	public static void Activate(Character activator, Character target) {
		activator.setManaPoints(activator.getManaPoints()-manaCost);
	}
}
