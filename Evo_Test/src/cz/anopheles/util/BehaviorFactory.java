package cz.anopheles.util;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import cz.anopheles.creature.api.IBehavior;
import cz.anopheles.creature.api.ICreature;
import cz.anopheles.creature.model.BehaviorSurvival;

public class BehaviorFactory {

	private BehaviorFactory(){
	}
	
	public static List<IBehavior> createBehaviorForSurvival(int size, ICreature creature){
		if(size <= 0)
			return null;
		
		Random ranGen = new Random();
		
		BehaviorSurvival[] behaviors = new BehaviorSurvival[size];
		
		for(int i = 0; i < size; i++){
			behaviors[i] = new BehaviorSurvival();
			behaviors[i].setMoveX(-2 + ranGen.nextInt(4));
			behaviors[i].setMoveY(-2 + ranGen.nextInt(4));
			behaviors[i].setCreature(creature);
		}
		
		return Arrays.asList((IBehavior[])behaviors);
	}
	
}
