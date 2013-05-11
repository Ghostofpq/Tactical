package com.gop.engine.equipement.armors;

import java.util.List;

import com.gop.engine.job.E_Job;
import com.gop.engine.race.E_Race;

public class Boots extends ArmorSet {

	public Boots(String name, String desc, List<E_Job> authorisedJobs,
			List<E_Race> authorisedRaces) {
		super(name, desc, authorisedJobs, authorisedRaces, E_Armor_Type.BOOTS);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip() {
		if (this.getEquipement().getBoots() != null) {
			this.getEquipement().getBoots().unequip();
		}
		this.getEquipement().getInventory().remove(this);
		this.getEquipement().setBoots(this);
	}

	@Override
	public void unequip() {
		this.getEquipement().getInventory().add(this);
		this.getEquipement().setBoots(null);
	}

}
