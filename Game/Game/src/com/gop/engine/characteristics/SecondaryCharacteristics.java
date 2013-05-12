package com.gop.engine.characteristics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecondaryCharacteristics {

	private int attackDamage;
	private int magicalDamage;

	private int armor;
	private int magicResist;
	private int armorPenetration;
	private int magicPenetration;

	private int speed;

	private int lifeRegeneration;
	private int manaRegeneration;

	private float escape;
	private float criticalStrike;
	private float precision;
	private float resilience;

	public SecondaryCharacteristics(int attackDamage, int magicalDamage,
			int armor, int magicResist, int armorPenetration,
			int magicPenetration, int speed, int lifeRegeneration,
			int manaRegeneration, float escape, float criticalStrike,
			float precision, float resilience) {
		super();
		this.attackDamage = attackDamage;
		this.magicalDamage = magicalDamage;
		this.armor = armor;
		this.magicResist = magicResist;
		this.armorPenetration = armorPenetration;
		this.magicPenetration = magicPenetration;
		this.speed = speed;
		this.lifeRegeneration = lifeRegeneration;
		this.manaRegeneration = manaRegeneration;
		this.escape = escape;
		this.criticalStrike = criticalStrike;
		this.precision = precision;
		this.resilience = resilience;
	}

	public SecondaryCharacteristics(PrimaryCharacteristics caracteristics) {
		this.attackDamage = caracteristics.getStrength();
		this.magicalDamage = caracteristics.getIntelligence();
		this.armor = caracteristics.getEndurance();
		this.magicResist = caracteristics.getWill();
		this.armorPenetration = 0;
		this.magicPenetration = 0;
		this.speed = 0;
		this.lifeRegeneration = 0;
		this.manaRegeneration = 0;
		this.escape = caracteristics.getAgility() / 1000;
		this.criticalStrike = caracteristics.getStrength() / 1000;
		this.precision = caracteristics.getAgility() / 1000;
		this.resilience = (caracteristics.getWill() / 1000)
				+ (caracteristics.getEndurance() / 1000);
	}

	public void plus(SecondaryCharacteristics secondaryCharacteristics) {
		this.setAttackDamage(this.getAttackDamage()
				+ secondaryCharacteristics.getAttackDamage());
		this.setMagicalDamage(this.getMagicalDamage()
				+ secondaryCharacteristics.getMagicalDamage());
		this.setArmor(this.getArmor() + secondaryCharacteristics.getArmor());
		this.setMagicResist(this.getMagicResist()
				+ secondaryCharacteristics.getMagicResist());
		this.setArmorPenetration(this.getArmorPenetration()
				+ secondaryCharacteristics.getArmorPenetration());
		this.setMagicPenetration(this.getMagicPenetration()
				+ secondaryCharacteristics.getMagicPenetration());
		this.setSpeed(this.getSpeed() + secondaryCharacteristics.getSpeed());
		this.setLifeRegeneration(this.getLifeRegeneration()
				+ secondaryCharacteristics.getLifeRegeneration());
		this.setManaRegeneration(this.getManaRegeneration()
				+ secondaryCharacteristics.getManaRegeneration());
		this.setEscape(this.getEscape() + secondaryCharacteristics.getEscape());
		this.setCriticalStrike(this.getCriticalStrike()
				+ secondaryCharacteristics.getCriticalStrike());
		this.setPrecision(this.getPrecision()
				+ secondaryCharacteristics.getPrecision());
		this.setResilience(this.getResilience()
				+ secondaryCharacteristics.getResilience());
	}
}
