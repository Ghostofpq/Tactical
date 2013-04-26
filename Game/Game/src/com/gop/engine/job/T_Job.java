package com.gop.engine.job;

import java.util.List;

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
}
