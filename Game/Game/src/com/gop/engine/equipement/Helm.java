package com.gop.engine.equipement;

import java.util.List;

import com.gop.engine.job.E_Job;
import com.gop.engine.race.E_Race;

public class Helm extends Armor {

	public Helm(String name, String desc, List<E_Job> authorisedJobs,
			List<E_Race> authorisedRaces) {
		super(name, desc, authorisedJobs, authorisedRaces, E_Armor_Type.HELM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void equip() {
		if (this.getEquipement().getHelm() != null) {
			this.getEquipement().getHelm().unequip();
		}
		this.getEquipement().getInventory().remove(this);
		this.getEquipement().setHelm(this);
	}

	@Override
	public void unequip() {
		this.getEquipement().getInventory().add(this);
		this.getEquipement().setHelm(null);
	}

}
