package cz.anopheles.creature.api;

public interface IBehavior {

	/**
	 * Thinking of every creature. :)
	 */
	public void behave();
	
	/**
	 * Creature which behaves like this.
	 * 
	 * @param creature
	 */
	public void setCreature(ICreature creature);
}
