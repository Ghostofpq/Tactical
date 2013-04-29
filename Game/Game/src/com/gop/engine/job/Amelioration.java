package com.gop.engine.job;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.character.Characteristics;

@Getter
@Setter
public class Amelioration extends T_Capacity {

	private Characteristics caracteristics;

	public Amelioration(String name, String description,
			Characteristics caracteristics, int price) {
		this.prerequisites = new ArrayList<T_Capacity>();
		
		this.name = name;
		this.description = description;
		
		this.type = E_CapacityType.AMELIORATION;

		this.price = price;
		this.locked = true;

		this.caracteristics = caracteristics;
	}

}
