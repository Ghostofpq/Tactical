package com.gop.engine.equipement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipableItem extends Item {

	public EquipableItem(String name, String desc, E_Item_Type itemType) {
		super(name, desc, itemType);
	}

}
