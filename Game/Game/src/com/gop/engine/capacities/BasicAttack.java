package com.gop.engine.capacities;

import org.newdawn.slick.util.Log;
import java.lang.Math;
import com.gop.engine.Character;

public class BasicAttack extends Capacity {

	static int manaCost = 0;

	public static void Activate(Character activator, Character target) {
		int AD = activator.getAttackPower();
		int arm = target.getArmor() - activator.getArmorPenetration();
		float dmgRed = ((float) arm / ((float) arm + 100));
		float totalDmg = AD - (AD * dmgRed);
		Log.debug("======Attack======");
		Log.debug("AD : " + AD);
		Log.debug("arm : " + arm);
		Log.debug("dmgRed : " + dmgRed);
		Log.debug("totalDmg : " + totalDmg);
		target.setLifePoints(target.getLifePoints() - Math.round(totalDmg));
	}

}
