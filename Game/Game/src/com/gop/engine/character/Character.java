package com.gop.engine.character;

import lombok.Getter;
import lombok.Setter;

import com.gop.engine.Map;
import com.gop.engine.character.capacities.Range;
import com.gop.engine.character.capacities.Range.RangeType;
import com.gop.engine.character.job.Job.jobList;
import com.gop.graphics.Animation;
import com.gop.graphics.CharAnimationBible;
import com.gop.graphics.GameboardRender.viewPoint;

@Getter
@Setter
public class Character {

	public enum CharState {
		Walking, Standing, Hitting, Casting, TakingDmg, Wounded, Dead
	}

	private NewCharacter newCharacter;

	private float posX;
	private float posY;
	private float posZ;

	private float speed = 0.01f;

	private int currentTileX;
	private int currentTileY;

	private int tileToGoX;
	private int tileToGoY;

	private int currentLifePoints;
	private int currentManaPoints;

	private Range range;

	private CharState state;
	private CharState lastState;
	private int hourglass;
	private boolean isReadyToPlay;

	private Animation currentAnimation;

	private CharAnimationBible animationBible;

	private int spriteSpeed;
	private boolean isMoving;
	private boolean isDead;
	private boolean isPlaced;
	private boolean hasMoved;
	private boolean hasAttacked;

	public Character(NewCharacter newCharacter) {
		this.newCharacter = newCharacter;

		this.currentAnimation = null;
		this.setState(CharState.Standing);
		this.setLastState(this.getState());
		this.range = new Range();
		this.range.setRange(1);
		this.range.setRangeType(RangeType.Cross);

		hourglass = 100;
		isReadyToPlay = false;
		currentTileX = -1;
		currentTileY = -1;

		isPlaced = false;
		setHasMoved(false);
		setHasAttacked(false);
		isMoving = false;
		isDead = false;

		this.currentLifePoints = this.newCharacter.getLifePoint();
		this.currentManaPoints = this.newCharacter.getManaPoint();
	}

	public void HourglassTick() {
		if (!isDead()) {
			hourglass -= this.newCharacter.getCharacteristics().getAgility();
			if (hourglass <= 0) {
				hourglass = 0;
				setReadyToPlay(true);
				setHasMoved(false);
				hourglass = 100;
			}
		}
	}

	public void TurnIsOver() {
		setReadyToPlay(false);
		setHasMoved(false);
		setHasAttacked(false);
		hourglass = 100;
	}

	public void Update(float GameTimeLapse, Map map) {
		if (!isDead) {
			if (currentAnimation != null) {
				this.currentAnimation.Update(GameTimeLapse);
			}
			if (isMoving) {
				if (tileToGoX != currentTileX || tileToGoY != currentTileY) {
					setCurrentTileX(tileToGoX);
					setCurrentTileY(tileToGoY);
					posZ = map.getTile(currentTileX, currentTileY).getHeight();
				} else {
					isMoving = false;
				}
			}
			if (this.currentLifePoints == 0) {
				isDead = true;
				TurnIsOver();
			}
		}
	}

	public void linkAnimationBible(CharAnimationBible bible) {
		this.animationBible = bible;
	}

	public void SetCurrentAnimationViewPoint(viewPoint vp) {
		this.currentAnimation = animationBible.getAnimation(vp,
				jobList.valueOf(this.newCharacter.getCurrentJob().getName()),
				this.newCharacter.getRace().getRace(),
				this.newCharacter.getGender(), this.state);
	}

	public int getMovement() {
		return this.newCharacter.getCharacteristics().getMovement();
	}

	public int getInitiative() {
		return this.newCharacter.getCharacteristics().getAgility();
	}

	public void setCurrentTileX(int currentTileX) {
		this.currentTileX = currentTileX;
		this.posX = (float) currentTileX;
	}

	public void setCurrentTileY(int currentTileY) {
		this.currentTileY = currentTileY;
		this.posY = (float) currentTileY;
	}

	public void setLifePoints(int lifePoints) {
		if (lifePoints > 0) {
			this.currentLifePoints = lifePoints;
		} else {
			this.currentLifePoints = 0;
		}
	}
}
