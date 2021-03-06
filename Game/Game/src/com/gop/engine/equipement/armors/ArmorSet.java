package com.gop.engine.equipement.armors;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.equipement.EquipableItem;
import com.gop.engine.job.T_Job.E_Job;
import com.gop.engine.race.T_Race.E_Race;

@Getter
@Setter
public abstract class ArmorSet extends EquipableItem {
	public enum E_Armor_Type {
		GLOVES, HELM, ARMOR, SHIELD, BOOTS
	}

	private E_Armor_Type armorType;

	public ArmorSet(String name, String desc, List<E_Job> authorisedJobs,
			List<E_Race> authorisedRaces, E_Armor_Type armorType) {
		super(name, desc, E_Item_Type.ARMOR, authorisedJobs, authorisedRaces);
		this.armorType = armorType;

	}
}
