package cz.anopheles.statistics.api;

import cz.anopheles.creature.api.ICreature;

/**
 * Interface for results of testing.
 * 
 * @author Anopheles
 *
 */
public interface IResult {
	/**
	 * Returns tested creature.
	 * 
	 * @return
	 */
	public ICreature getCreature();
	/**
	 * Returns score of tested creature.
	 * 
	 * @return
	 */
	public double getScore();
}
