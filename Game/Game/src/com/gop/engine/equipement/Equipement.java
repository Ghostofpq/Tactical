package com.gop.engine.equipement;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equipement {
	private ArrayList<Item> inventory;

	private EquipableItem helm;
	private EquipableItem gloves;
	private EquipableItem armor;
	private EquipableItem boots;

	private EquipableItem hand1Slot;
	private EquipableItem hand2Slot;
	
	
}
