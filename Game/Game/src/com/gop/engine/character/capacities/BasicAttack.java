package com.gop.engine.character.capacities;

import org.newdawn.slick.util.Log;
import java.lang.Math;

import com.gop.engine.character.Character;

public class BasicAttack extends Capacity {

	static int manaCost = 0;

	public static void Activate(Character activator, Character target) {
		int AD = activator.getNewCharacter().getCharacteristics().getStrength();
		int arm = target.getNewCharacter().getCharacteristics().getEndurance() ;
		float dmgRed = ((float) arm / ((float) arm + 100));
		float totalDmg = ((float) AD - ((float) AD * dmgRed));
		Log.debug("======Attack======");
		Log.debug("AD : " + AD);
		Log.debug("arm : " + arm);
		Log.debug("dmgRed : " + dmgRed);
		Log.debug("totalDmg : " + totalDmg);
		target.setCurrentLifePoints(target.getCurrentLifePoints() - Math.round(totalDmg));
	}

}
