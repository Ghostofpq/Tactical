package com.gop.engine.equipement;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.job.E_Job;
import com.gop.engine.race.E_Race;

@Getter
@Setter
public abstract class Armor extends EquipableItem {

	private E_Armor_Type armorType;

	public Armor(String name, String desc, List<E_Job> authorisedJobs,
			List<E_Race> authorisedRaces, E_Armor_Type armorType) {
		super(name, desc, E_Item_Type.ARMOR, authorisedJobs, authorisedRaces);
		this.armorType = armorType;

	}
}
