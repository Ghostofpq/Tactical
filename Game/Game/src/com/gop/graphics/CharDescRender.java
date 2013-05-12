package com.gop.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.opengl.Texture;

import com.gop.engine.character.Character;

public class CharDescRender {
	private Texture Portrait;
	private UnicodeFont font;
	private float Xdep;
	private float Ydep;
	private Character currentChar;

	public void Render() {
		if (currentChar != null) {
			RenderName(Xdep, Ydep);
			RenderRace(Xdep, Ydep + 25f);
			RenderLvl(Xdep, Ydep + 50f);
			RenderJob(Xdep, Ydep + 75f);
		}
	}

	public void Init(UnicodeFont font) {
		this.font = font;
	}

	public void RenderName(float X, float Y) {
		Color.white.bind();
		font.drawString(X, Y, currentChar.getNewCharacter().getIdentity()
				.getName(), Color.white);
	}

	public void RenderRace(float X, float Y) {
		Color.white.bind();
		font.drawString(X, Y, currentChar.getNewCharacter().getIdentity()
				.getRace().getName(), Color.white);
	}

	public void RenderLvl(float X, float Y) {
		Color.white.bind();
		font.drawString(X, Y, "lvl : "
				+ currentChar.getNewCharacter().getLevel(), Color.white);
	}

	public void RenderJob(float X, float Y) {
		Color.white.bind();
		font.drawString(X, Y, currentChar.getNewCharacter().getCurrentJob()
				.getName(), Color.white);
	}

	public void setXdep(float xdep) {
		Xdep = xdep;
	}

	public void setYdep(float ydep) {
		Ydep = ydep;
	}

	public void SetCurrentChar(Character c) {
		this.currentChar = c;
	}
}
