package com.gop.engine.equipement;

import java.util.List;

import com.gop.engine.character.NewCharacter;
import com.gop.engine.job.E_Job;
import com.gop.engine.race.E_Race;

import lombok.Getter;
import lombok.Setter;

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
