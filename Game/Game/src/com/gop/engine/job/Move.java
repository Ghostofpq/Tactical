package com.gop.engine.job;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move extends T_Capacity {

	private static final long serialVersionUID = 768372563773451676L;

	public Move(String name, String description, int price) {
		this.prerequisites = new ArrayList<T_Capacity>();

		this.name = name;
		this.description = description;

		this.type = E_CapacityType.MOVE;

		this.price = price;
		this.locked = true;
	}
}
