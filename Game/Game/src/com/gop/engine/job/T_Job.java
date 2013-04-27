package com.gop.engine.job;

import java.util.List;

import com.gop.engine.character.Caracteristics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class T_Job {

	private String name;
	private String description;

	private List<T_Capacity> skillTree;

	private List<Move> unlockedMoves;
	private List<Amelioration> unlockedAmeliorations;

	private int jobPoints;
	private int cumulatedJobPoints;

	public T_Job(String name, String description) {
		this.name = name;
		this.description = description;

		this.jobPoints = 0;
		this.cumulatedJobPoints = 0;
	}

	public boolean canUnlockCapacity(T_Capacity capacity) {
		if (capacity.isAvailable() && this.jobPoints >= capacity.getPrice()
				&& !capacity.isLocked()) {
			return true;
		}
		return false;
	}

	public void unlockCapacity(T_Capacity capacity) {
		if (canUnlockCapacity(capacity)) {
			this.jobPoints -= capacity.getPrice();
			capacity.setLocked(false);

			switch (capacity.getType()) {
			case AMELIORATION:
				unlockedAmeliorations.add((Amelioration) capacity);
				break;
			case MOVE:
				unlockedMoves.add((Move) capacity);
				break;
			}
		}
	}

	public Caracteristics getAggregatedCaracteristics() {
		Caracteristics result = new Caracteristics(0, 0, 0, 0, 0, 0);

		for (Amelioration amelioration : unlockedAmeliorations) {
			result.plus(amelioration.getCaracteristics());
		}

		return result;
	}
}