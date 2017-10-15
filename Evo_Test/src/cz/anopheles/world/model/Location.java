package cz.anopheles.world.model;

import cz.anopheles.world.api.ILocation;
import cz.anopheles.world.api.ILocationEffect;

public class Location implements ILocation {

	private char locationType;
	private ILocationEffect locationEffect;
	
	public Location(ILocationEffect effect){
		this.locationEffect = effect;
	}

	@Override
	public void setLocationEffect(ILocationEffect effect) {
		this.locationEffect = effect;
	}

	@Override
	public ILocationEffect getLocationEffect() {
		return locationEffect;
	}

	@Override
	public void setLocationType(char locationType) {
		this.locationType = locationType;
	}

	@Override
	public char getLocationType() {
		return locationType;
	}
	
}
