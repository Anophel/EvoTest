package cz.anopheles.world.api;

import cz.anopheles.creature.api.ICreature;

/**
 * Interface for every location effect.
 * 
 * @author Anopheles
 *
 */
public interface ILocationEffect {

	/**
	 * Does effect on given creature and return if it was successful or
	 * if it failed.
	 * 
	 * @param creature
	 * @return success
	 */
	public boolean doEffect(ICreature creature);
	
	/**
	 * Gives type of effect.
	 * 
	 * @return
	 */
	public char getType();
}
