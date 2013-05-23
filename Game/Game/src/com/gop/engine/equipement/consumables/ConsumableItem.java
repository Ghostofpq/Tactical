package com.gop.engine.equipement.consumables;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.equipement.Item;

@Getter
@Setter
public abstract class ConsumableItem extends Item implements Consumable {

	public ConsumableItem(String name, String desc, E_Item_Type itemType) {
		super(name, desc, itemType);
	}

}
