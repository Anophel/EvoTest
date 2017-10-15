package cz.anopheles.creature.model;

import cz.anopheles.creature.api.IBehavior;
import cz.anopheles.creature.api.ICreature;

public class BehaviorSurvival implements IBehavior {

	private int moveX;
	private int moveY;
	private CreatureSurvival creature;
	
	@Override
	public void behave() {
		creature.setX(creature.getX() + moveX);
		creature.setY(creature.getY() + moveY);
	}

	public int getMoveX() {
		return moveX;
	}

	public void setMoveX(int moveX) {
		this.moveX = moveX;
	}

	public int getMoveY() {
		return moveY;
	}

	public void setMoveY(int moveY) {
		this.moveY = moveY;
	}

	@Override
	public void setCreature(ICreature creature) {
		this.creature = (CreatureSurvival) creature;
	}

	public ICreature getCreature(){
		return creature;
	}
}
