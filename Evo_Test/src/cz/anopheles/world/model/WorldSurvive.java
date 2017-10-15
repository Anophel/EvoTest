package cz.anopheles.world.model;

import cz.anopheles.creature.api.ICreature;
import cz.anopheles.creature.model.CreatureSurvival;
import cz.anopheles.exceptions.EvoException;
import cz.anopheles.statistics.api.IResult;
import cz.anopheles.statistics.model.ResultSurvival;
import cz.anopheles.util.CodeList;
import cz.anopheles.util.MapFactory;
import cz.anopheles.world.api.IMap;
import cz.anopheles.world.api.IWorld;

public class WorldSurvive implements IWorld {

	public static final int MAP_WIDTH = 64;
	public static final int MAP_HEIGHT = 64;
	public static final int MAX_DAYS = 36500;
	
	private int state;
	private IMap map;
	private ICreature[] creatures;
	private IResult[] results;


	@Override
	public IMap getMap() {
		return map;
	}

	public WorldSurvive(){
		state = CodeList.SIMULATION_NOT_READY;
	}
	
	@Override
	public void run() {
		if(state != CodeList.SIMULATION_READY)
			return;
		
		state = CodeList.SIMULATION_RUNNING;
		
		for(int i = 0; i < creatures.length; i++){
			results[i] = simulate((CreatureSurvival)creatures[i]);
		}
		
		state = CodeList.SIMULATION_DONE;
	}

	private IResult simulate(CreatureSurvival creature){
		int days = 0;
		
		while(creature.getHunger() > 0){
			creature.act();
			if(creature.getX() >= map.getWidth())
				creature.setX(map.getWidth() - 1);
			if(creature.getY() >= map.getHeight())
				creature.setY(map.getHeight() - 1);
			if(creature.getX() < 0)
				creature.setX(0);
			if(creature.getY() < 0)
				creature.setY(0);
			
			map.getLocation(creature.getX(), creature.getY()).getLocationEffect().doEffect(creature);
			
			days++;
			if(days == MAX_DAYS)
				break;
		}
		
		ResultSurvival result = new ResultSurvival();
		result.setCreature(creature);
		result.setDaysSurvived(days);
		return result;
	}
	
	@Override
	public boolean initialize(ICreature[] creatures) {
		this.creatures = creatures;
		
		try {
			map = MapFactory.createSurvivalMapAdvanced(MAP_WIDTH, MAP_HEIGHT);
		} catch (EvoException e) {
			state = CodeList.SIMULATION_NOT_READY;
			System.err.println(e.getMessage());
			return false;
		}
		
		this.results = new IResult[creatures.length];
		
		state = CodeList.SIMULATION_READY;
		return true;
	}
	
	@Override
	public int getState() {
		return state;
	}
	
	public IResult[] getResults() {
		return results;
	}
}
