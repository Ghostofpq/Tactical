package com.gop.engine.job;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.characteristics.PrimaryCharacteristics;

@Getter
@Setter
public class Amelioration extends T_Capacity {

	private static final long serialVersionUID = -7036564291741868266L;
	
	private PrimaryCharacteristics caracteristics;

	public Amelioration(String name, String description,
			PrimaryCharacteristics caracteristics, int price) {
		this.prerequisites = new ArrayList<T_Capacity>();
		
		this.name = name;
		this.description = description;
		
		this.type = E_CapacityType.AMELIORATION;

		this.price = price;
		this.locked = true;

		this.caracteristics = caracteristics;
	}

}
