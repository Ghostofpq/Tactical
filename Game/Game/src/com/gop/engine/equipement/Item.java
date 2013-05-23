package com.gop.engine.equipement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
	public enum E_Item_Type {
		WEAPON, ARMOR, CONSUMABLE
	}

	private Equipement equipement;

	private String name;
	private String desc;

	private E_Item_Type itemType;

	public Item(String name, String desc, E_Item_Type itemType) {
		this.name = name;
		this.desc = desc;
		this.itemType = itemType;
	}
}
