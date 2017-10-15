package cz.anopheles.creature.model;

import java.util.ArrayList;

import cz.anopheles.creature.api.IBehavior;
import cz.anopheles.creature.api.ICreature;
import cz.anopheles.util.CodeList;

public class CreatureSurvival implements ICreature {

	private int creatureType;
	private int foodInStock;
	private int hunger;		// 0 = dead, 100 = full
	private int x;
	private int y;
	private ArrayList<IBehavior> behaviors;
	private int behaviorIndex;
	
	public CreatureSurvival(){
		creatureType = CodeList.CREATURE_TYPE_SURVIVAL;
		behaviors = new ArrayList<IBehavior>();
		behaviorIndex=0;
	}

	@Override
	public int getCreatureType() {
		return creatureType;
	}

	public int getFoodInStock() {
		return foodInStock;
	}

	public void setFoodInStock(int foodInStock) {
		this.foodInStock = foodInStock;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		if((this.hunger + hunger) > 100)
			this.hunger = 100;
		else
			this.hunger = hunger;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public ArrayList<IBehavior> getBehaviors() {
		return behaviors;
	}

	@Override
	public void act() {
		if(behaviors.size() <= 0)
			return;
		
		behaviors.get(behaviorIndex % behaviors.size()).behave();
		behaviorIndex++;
	}
}
