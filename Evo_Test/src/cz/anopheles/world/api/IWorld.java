package cz.anopheles.world.api;

import cz.anopheles.creature.api.ICreature;
import cz.anopheles.statistics.api.IResult;

/**
 * Interface of world controls whole test.
 * When world gets to the state running defined in {@link CodeList#}, the test starts.
 * Creatures are running on the {@link IMap} and are affected by {@link ILocation} and
 * their {@link ILocationEffect}
 * 
 * @author Anopheles
 *
 */
public interface IWorld extends Runnable{
	
	/**
	 * Sets creatures, that are going to be tested and prepares map.
	 * 
	 * @param creatures
	 * @return succed
	 */
	public boolean initialize(ICreature[] creatures);
	/**
	 * Return state in which is.
	 * 
	 * @return state
	 */
	public int getState();
	
	/**
	 * Gives results of testing.
	 * 
	 * @return
	 */
	public IResult[] getResults();
	
	/**
	 * Gives map on which are creatures are tested.
	 * 
	 * @return
	 */
	public IMap getMap(); 
}
