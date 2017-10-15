package cz.anopheles.world.api;

import cz.anopheles.util.CodeList;

/**
 * Interface of map, where testing creatures are tested.
 * 
 * @author Anopheles
 *
 */
public interface IMap {

	/**
	 * Get location by its coordinates.
	 * 
	 * 
	 * @param x
	 * @param y
	 * @return ILocation. Null when coordinates are out of bound or map has not been initialized yet.
	 */
	public ILocation getLocation(int x, int y);
	
	/**
	 * Gives state, if it is already initialized or not.
	 * Corresponds with {@link CodeList}
	 * 
	 * @return
	 */
	public int getState();
	
	/**
	 * Inits map with given locations;
	 * 
	 * @param locations
	 * @return false = could not init, maybe it was already initialized
	 */
	public boolean init(ILocation[][] locations);
	
	/**
	 * Gives width of map.
	 * @return
	 */
	public int getWidth();
	
	/**
	 * Gives height of map.
	 * @return
	 */
	public int getHeight();
}
