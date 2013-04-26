package com.engine.job;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move extends T_Capacity {

	public Move(String name, String description, int price) {
		this.name = name;
		this.description = description;

		this.type = E_CapacityType.MOVE;

		this.price = price;
		this.locked = true;
	}
}
