package com.gop.graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.gop.engine.character.Character.CharState;
import com.gop.engine.character.CharacterData.Gender;
import com.gop.engine.character.job.Job.jobList;
import com.gop.engine.race.T_Race.E_Race;
import com.gop.graphics.GameboardRender.viewPoint;

public class CharAnimation extends Animation {

	public CharAnimation(viewPoint vp, jobList job, E_Race race, Gender gen,
			CharState state) {
		String path = super.basicPath
				+ (race.toString() + "/" + gen.toString() + "/"
						+ job.toString() + "/" + state.toString() + "/" + vp
							.toString());
		this.speed = 0;
		this.count = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path
					+ "desc.txt"));
			String save = "";
			String buff = in.readLine();
			while (buff != null) {
				save += buff;
				buff = in.readLine();
			}
			in.close();
			this.speed = Integer.valueOf(GetXMLElement(save, "Speed"));
			this.speed = Integer.valueOf(GetXMLElement(save, "Count"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		this.timer = 0;
		this.index = 0;
	}

	private String GetXMLElement(String XMLString, String balise) {
		int len = ("<" + balise + ">").length();
		int posDeb = XMLString.indexOf("<" + balise + ">");
		int posFin = XMLString.indexOf("</" + balise + ">");

		return XMLString.substring(posDeb + len, posFin);
	}
}
