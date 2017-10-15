package cz.anopheles.creature.api;

/**
 * Interface for every creature that is tested.
 * 
 * @author Anopheles
 *
 */
public interface ICreature {

	/**
	 * Gives type of creature.
	 * 
	 * @return
	 */
	public int getCreatureType();
	
	/**
	 * Performs an action of creature.
	 */
	public void act();
}
