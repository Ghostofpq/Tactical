package com.gop.engine.equipement.weapons;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.equipement.E_Item_Type;
import com.gop.engine.equipement.EquipableItem;
import com.gop.engine.job.E_Job;
import com.gop.engine.race.T_Race.E_Race;

@Getter
@Setter
public class Weapon extends EquipableItem {

	private E_Weapon_Type weaponType;

	public Weapon(String name, String desc, E_Weapon_Type weaponType,
			List<E_Job> authorisedJobs, List<E_Race> authorisedRaces) {
		super(name, desc, E_Item_Type.WEAPON, authorisedJobs, authorisedRaces);
		this.weaponType = weaponType;
	}

	@Override
	public void equip() {

	}

	@Override
	public void unequip() {

	}

}
