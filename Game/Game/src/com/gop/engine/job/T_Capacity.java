package com.gop.engine.job;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class T_Capacity implements Serializable {

	private static final long serialVersionUID = 6338786566341517746L;

	public enum E_CapacityType {
		AMELIORATION, MOVE
	}

	protected String name;
	protected String description;
	protected E_CapacityType type;

	protected int price;
	protected boolean locked;

	protected List<T_Capacity> prerequisites;

	public boolean isAvailable() {
		if (prerequisites.isEmpty()) {
			return true;
		} else {
			for (T_Capacity prerequisite : prerequisites) {
				if (prerequisite.isLocked()) {
					return false;
				}
			}
			return true;
		}
	}

	protected void addPrerequisites(T_Capacity prerequisite) {
		prerequisites.add(prerequisite);
	}
}
