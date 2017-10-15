package cz.anopheles.util;

import java.util.Random;

import cz.anopheles.exceptions.EvoException;
import cz.anopheles.world.api.ILocation;
import cz.anopheles.world.api.ILocationEffect;
import cz.anopheles.world.api.IMap;
import cz.anopheles.world.effects.EffectSurvival;
import cz.anopheles.world.effects.EffectSurvivalEat;
import cz.anopheles.world.effects.EffectSurvivalGather;
import cz.anopheles.world.effects.EffectSurvivalStarve;
import cz.anopheles.world.model.Location;
import cz.anopheles.world.model.Map;

public class MapFactory {

	private static int SURVIVAL_ADVANCED_MAX_AREAS = 18;
	private static int SURVIVAL_ADVANCED_MIN_AREAS = 7;
	private static int SURVIVAL_ADVANCED_MAX_RADIUS = 8;
	
	private static Random ranGen;
	
	static{
		ranGen = new Random(System.currentTimeMillis());
	}
	
	/**
	 * Creates map with survival locations.
	 * This method is simple with total random algorithm.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public static IMap createSurvivalMapBasic(int width, int height) throws EvoException{
		if(width <= 0 || height <= 0)
			throw new EvoException("Wrong size of map.");
		
		ILocationEffect[] effects = getAllSurvivalEffects();
		
		IMap map = new Map();
		ILocation[][] locations = new ILocation[width][height];
		for(int j = 0; j < height; j++){
			for(int i = 0; i < height; i++){
				int seed = ranGen.nextInt(effects.length);
				locations[i][j] = new Location(effects[seed]);
				locations[i][j].setLocationType(effects[seed].getType());
			}
		}
		map.init(locations);
		
		return map;
	}
	
	/**
	 * Creates map with survival locations.
	 * This method is advanced. The map is not total chaos any more, but there are
	 * larger areas where are different locations, so it is more realistic.
	 * 
	 * @param width
	 * @param height
	 * @return
	 */
	public static IMap createSurvivalMapAdvanced(int width, int height) throws EvoException{
		if(width <= 0 || height <= 0)
			throw new EvoException("Wrong size of map.");
		
		ILocationEffect[] effects = getAllSurvivalEffects();
		
		IMap map = new Map();
		ILocation[][] locations = new ILocation[width][height];
		
		for(int j = 0; j < height; j++){
			for(int i = 0; i < height; i++){
				int seed = 0;
				locations[i][j] = new Location(effects[seed]);
				locations[i][j].setLocationType(effects[seed].getType());
			}
		}
		
		int numOfAreas = SURVIVAL_ADVANCED_MIN_AREAS + ranGen.nextInt(SURVIVAL_ADVANCED_MAX_AREAS - SURVIVAL_ADVANCED_MIN_AREAS);
		
		for(int i = 0; i < numOfAreas; i++){
			locations = putRandomLargeAreaLocation(locations, width, height, effects);
		}
		
		map.init(locations);
		
		return map;
	}
	
	/**
	 * Creates large areas with same locations.
	 * 
	 * @param locations
	 * @param width
	 * @param height
	 * @param effects	skips first effect.
	 * @return
	 */
	private static ILocation[][] putRandomLargeAreaLocation(ILocation[][] locations, int width, int height, ILocationEffect[] effects){
		for(int j = 0; j < height; j++){
			for(int i = 0; i < height; i++){
				int midX = ranGen.nextInt(width);
				int midY = ranGen.nextInt(height);
				int radius = 2 + ranGen.nextInt(SURVIVAL_ADVANCED_MAX_RADIUS-2);
				if(isInCircle(midX, midY, radius, i, j)){
					int seed = 1 + ranGen.nextInt(effects.length - 1);
					locations[i][j] = new Location(effects[seed]);
					locations[i][j].setLocationType(effects[seed].getType());
				}
			}
		}
		
		return locations;
	}
	
	public static boolean isInCircle(int midX, int midY, int radius, int pointX, int pointY){
		double left = Math.pow(midX-pointX, 2) + Math.pow(midY - pointY, 2);
		double right = radius*radius;
		
		return left <= right;
	}
	
	private static EffectSurvival[] getAllSurvivalEffects(){
		EffectSurvival[] effects = new EffectSurvival[3];
		int i = 0;
		effects[i++] = new EffectSurvivalStarve();
		effects[i++] = new EffectSurvivalGather();
		effects[i++] = new EffectSurvivalEat();
		
		return effects;
	}
}
