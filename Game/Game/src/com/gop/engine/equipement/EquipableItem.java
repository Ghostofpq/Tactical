package com.gop.engine.equipement;

import java.util.List;

import com.gop.engine.character.NewCharacter;
import com.gop.engine.job.E_Job;
import com.gop.engine.race.E_Race;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EquipableItem extends Item implements Equipable {

	private List<E_Job> authorisedJobs;
	private List<E_Race> authorisedRaces;

	public EquipableItem(String name, String desc, E_Item_Type itemType,
			List<E_Job> authorisedJobs, List<E_Race> authorisedRaces) {
		super(name, desc, itemType);
		this.authorisedJobs = authorisedJobs;
		this.authorisedRaces = authorisedRaces;
	}
}
