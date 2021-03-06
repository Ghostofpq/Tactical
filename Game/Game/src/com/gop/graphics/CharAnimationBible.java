package com.gop.graphics;

import com.gop.engine.character.Character.CharState;
import com.gop.engine.character.CharacterData.Gender;
import com.gop.engine.character.job.Job.jobList;
import com.gop.engine.race.T_Race.E_Race;
import com.gop.graphics.GameboardRender.viewPoint;

public class CharAnimationBible {
	int nbPointsOfView = 4;
	int nbJobs = 3;
	int nbRaces = 3;
	int nbGenders = 3;
	int nsStances = 7;

	private Animation[][][][][] AnimationBible;

	public CharAnimationBible() {
		AnimationBible = new Animation[nbPointsOfView][nbJobs][nbRaces][nbGenders][nsStances];
	}

	public Animation getAnimation(viewPoint vp, jobList job, E_Race race,
			Gender gen, CharState state) {
		return AnimationBible[vp.ordinal()][job.ordinal()][race.ordinal()][gen
				.ordinal()][state.ordinal()];
	}

	public void CreateAll() {
		for (viewPoint vp : viewPoint.values()) {
			for (jobList job : jobList.values()) {
				for (E_Race race : E_Race.values()) {
					for (Gender gen : Gender.values()) {
						for (CharState state : CharState.values()) {
							AnimationBible[vp.ordinal()][job.ordinal()][race
									.ordinal()][gen.ordinal()][state.ordinal()] = new CharAnimation(
									vp, job, race, gen, state);
						}
					}
				}
			}
		}
	}

	public void LoadAll() {
		for (viewPoint vp : viewPoint.values()) {
			for (jobList job : jobList.values()) {
				for (E_Race race : E_Race.values()) {
					for (Gender gen : Gender.values()) {
						for (CharState state : CharState.values()) {
							AnimationBible[vp.ordinal()][job.ordinal()][race
									.ordinal()][gen.ordinal()][state.ordinal()]
									.Load();
						}
					}
				}
			}
		}
	}

}
