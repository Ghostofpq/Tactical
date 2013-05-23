package com.gop.engine.equipement.armors;

import java.util.List;

import com.gop.engine.job.T_Job.E_Job;
import com.gop.engine.race.T_Race.E_Race;

public class Armor extends ArmorSet {

	public Armor(String name, String desc, List<E_Job> authorisedJobs,
			List<E_Race> authorisedRaces) {
		super(name, desc, authorisedJobs, authorisedRaces, E_Armor_Type.ARMOR);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip() {
		if (this.getEquipement().getArmor() != null) {
			this.getEquipement().getArmor().unequip();
		}
		this.getEquipement().getInventory().remove(this);
		this.getEquipement().setArmor(this);
	}

	@Override
	public void unequip() {
		this.getEquipement().getInventory().add(this);
		this.getEquipement().setArmor(null);
	}

}