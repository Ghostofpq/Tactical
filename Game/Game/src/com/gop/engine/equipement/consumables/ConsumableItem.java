package com.gop.engine.equipement.consumables;

import com.gop.engine.equipement.E_Item_Type;
import com.gop.engine.equipement.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ConsumableItem extends Item implements Consumable {

	public ConsumableItem(String name, String desc, E_Item_Type itemType) {
		super(name, desc, itemType);
	}

}
