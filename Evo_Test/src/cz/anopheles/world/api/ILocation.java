package cz.anopheles.world.api;

/**
 * Interface of any location. Location is basic stone of every map.
 * 
 * @author Anopheles
 *
 */
public interface ILocation {

	/**
	 * Sets type of location.
	 * Take value from CodeList
	 * 
	 * @param locationType
	 */
	public void setLocationType(char locationType);
	/**
	 * Gets type of location.
	 * Should return value from CodeList
	 * 
	 */
	public char getLocationType();
	/**
	 * Sets effect of location. This effect defines, what happens with creature
	 * on this location.
	 * 
	 * @param effect
	 */
	public void setLocationEffect(ILocationEffect effect);
	/**
	 * Gets effect of location. This effect defines, what happens with creature
	 * on this location.
	 * 
	 */
	public ILocationEffect getLocationEffect();
}
