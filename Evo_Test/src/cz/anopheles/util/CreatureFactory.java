package cz.anopheles.util;

import java.util.Random;

import cz.anopheles.creature.api.ICreature;
import cz.anopheles.creature.model.CreatureSurvival;

public class CreatureFactory {

	private static final int DEFAULT_HUNGER = 20;
	private static final int DEFAULT_FOOD_IN_STOCK = 5;
	private static final int DEFAULT_MIN_BEHAVIORS = 3;
	private static final int DEFAULT_MAX_BEHAVIORS = 6;
	
	public static ICreature[] createSurvivalCreatures(int size){
		if(size <= 0)
			return null;
		CreatureSurvival[] creatures = new CreatureSurvival[size];
		Random ranGen = new Random(System.currentTimeMillis());
		for(int i = 0; i < size; i++){
			creatures[i] = new CreatureSurvival();
			creatures[i].setHunger(DEFAULT_HUNGER);
			creatures[i].setFoodInStock(DEFAULT_FOOD_IN_STOCK);
			creatures[i].getBehaviors().addAll(BehaviorFactory.createBehaviorForSurvival(
					DEFAULT_MIN_BEHAVIORS + ranGen.nextInt(DEFAULT_MAX_BEHAVIORS-DEFAULT_MIN_BEHAVIORS), creatures[i]));
		}
		
		return creatures;
	}
	
}
