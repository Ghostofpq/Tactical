package com.gop.engine.equipement.armors;

import java.util.List;

import com.gop.engine.job.E_Job;
import com.gop.engine.race.T_Race.E_Race;

public class Gloves extends ArmorSet {

	public Gloves(String name, String desc, List<E_Job> authorisedJobs,
			List<E_Race> authorisedRaces) {
		super(name, desc, authorisedJobs, authorisedRaces, E_Armor_Type.GLOVES);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip() {
		if (this.getEquipement().getGloves() != null) {
			this.getEquipement().getGloves().unequip();
		}
		this.getEquipement().getInventory().remove(this);
		this.getEquipement().setGloves(this);
	}

	@Override
	public void unequip() {
		this.getEquipement().getInventory().add(this);
		this.getEquipement().setGloves(null);
	}

}