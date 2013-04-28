package com.gop.graphics;

import org.newdawn.slick.Color;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.opengl.Texture;

import com.gop.engine.character.Character;

public class CharBarsRender {
	private float Xdep;
	private float Ydep;
	private UnicodeFont font;
	private Character currentChar;
	BarDrawer HPBar;
	BarDrawer MPBar;

	public CharBarsRender() {
		Xdep = 0;
		Ydep = 0;
		currentChar = null;
		HPBar = new BarDrawer(0.8f, 0.05f, 0.09f);
		MPBar = new BarDrawer(0.0f, 0.0f, 1.0f);
	}

	public void Init(Texture HP, Texture MP, UnicodeFont font) {
		this.font = font;
		HPBar.Init();
		MPBar.Init();
		HPBar.setIcon(HP);
		MPBar.setIcon(MP);
	}

	public void Render() {
		if (currentChar != null) {
			float a = ((float) currentChar.getCurrentLifePoints() / (float) currentChar
					.getCurrentManaPoints()) * 100f;
			HPBar.Render(a);
			float b = ((float) currentChar.getNewCharacter().getLifePoint() / (float) currentChar
					.getNewCharacter().getManaPoint()) * 100f;
			MPBar.Render(b);

			font.drawString(Xdep + 50f, Ydep,
					currentChar.getCurrentLifePoints() + "/"
							+ currentChar.getNewCharacter().getLifePoint(),
					Color.white);
			font.drawString(Xdep + 50f, Ydep + 25f,
					currentChar.getCurrentManaPoints() + "/"
							+ currentChar.getNewCharacter().getManaPoint(),
					Color.white);
		}
	}

	public void setXdep(float xdep) {
		Xdep = xdep;
		HPBar.setXdep(xdep);
		MPBar.setXdep(xdep);
	}

	public void setYdep(float ydep) {
		Ydep = ydep;
		HPBar.setYdep(ydep);
		MPBar.setYdep(ydep + 25f);
	}

	public void setCurrentChar(Character c) {
		this.currentChar = c;
	}

}
