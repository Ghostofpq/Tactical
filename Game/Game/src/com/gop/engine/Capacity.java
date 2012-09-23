package com.gop.engine;

public abstract class Capacity {

	protected Range range;
	protected int manaCost;

	protected abstract void Activate(Character activator, Character taget);
}
