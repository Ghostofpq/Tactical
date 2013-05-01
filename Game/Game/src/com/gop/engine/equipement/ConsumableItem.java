package com.gop.engine.equipement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ConsumableItem extends Item implements Consumable {

	public ConsumableItem(String name, String desc, E_Item_Type itemType) {
		super(name, desc, itemType);
	}

}
