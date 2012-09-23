package com.gop.engine;

public class Skill {

	public enum skillType {
		amelioration, capacity
	}

	private String name;
	private String desc;
	private boolean isActive; // can be bougth, unlocked.
	private boolean isBought; // is bought, must be applied.
	private int expPrice;
	private skillType type;
	private boolean[] dependance;

	public Skill(String name, String desc, int expPrice, skillType type) {
		setName(name);
		setDesc(desc);
		setExpPrice(expPrice);
		setActive(false);
		setBought(false);
		setType(type);
		setDependance(new boolean[0]);
		RefreshDependencies();
	}

	public void process(Character character) {
		// set here the code !!
		// if skill, activate the right boolean in the char
		// if amelioration, upgrade the char stats.
	}

	public int BuySkill(int expPoint) {
		if (isActive()) {
			// Skill is visible in the tree
			if (!isBought()) {
				if (expPrice <= expPoint) {
					expPoint -= expPoint;
					setActive(true);
					// Action OK
					return 0;
				} else {
					// YOU'VE NOT ENOUGH MINERALS
					return 1;
				}
			} else {
				return 2;
				// Already bougth
			}
		}
		return 3;
	}

	public void RefreshDependencies() {
		boolean result = true;
		for (int i = 0; i < dependance.length; i++) {
			if (dependance[i] == false) {
				result = false;
			}
		}
		setActive(result);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isBought() {
		return isBought;
	}

	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}

	public int getExpPrice() {
		return expPrice;
	}

	public void setExpPrice(int expPrice) {
		this.expPrice = expPrice;
	}

	public skillType getType() {
		return type;
	}

	public void setType(skillType type) {
		this.type = type;
	}

	public boolean[] getDependance() {
		return dependance;
	}

	public void setDependance(boolean[] dependance) {
		this.dependance = dependance;
		RefreshDependencies();
	}
}
