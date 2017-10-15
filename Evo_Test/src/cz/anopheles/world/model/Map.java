package cz.anopheles.world.model;

import cz.anopheles.util.CodeList;
import cz.anopheles.world.api.ILocation;
import cz.anopheles.world.api.IMap;

public class Map implements IMap {

	private int state;
	private ILocation[][] locations; // [x][y]
	
	public Map(){
		state = CodeList.MAP_NOT_INIT;
	}
	
	@Override
	public ILocation getLocation(int x, int y) {
		if(state == CodeList.MAP_NOT_INIT || x < 0 || x >= locations.length || y < 0 || y >= locations[0].length)
			return null;
		else
			return locations[x][y];
	}
	
	@Override
	public int getState() {
		return state;
	}

	@Override
	public boolean init(ILocation[][] locations) {
		if(state != CodeList.MAP_NOT_INIT)
			return false;
		
		this.locations = locations;
		state = CodeList.MAP_INIT;
		return true;
	}

	@Override
	public int getWidth() {
		return locations.length;
	}

	@Override
	public int getHeight() {
		return locations[0].length;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int height = locations[0].length;
		int width = locations.length;
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				sb.append("|" + locations[i][j].getLocationType());
			}
			sb.append("\n");
			for(int j = 0; j < height; j++){
				sb.append("-");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
