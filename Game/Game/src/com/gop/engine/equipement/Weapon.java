package com.gop.engine.equipement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weapon extends EquipableItem {

	private E_Weapon_Type weaponType;

	public Weapon(String name, String desc, E_Weapon_Type weaponType) {
		super(name, desc, E_Item_Type.WEAPON);
		this.weaponType = weaponType;
	}

}
