package cz.anopheles.statistics.model;

import cz.anopheles.creature.api.ICreature;
import cz.anopheles.statistics.api.IResult;

public class ResultSurvival implements IResult {

	public ICreature creature;
	public double daysSurvived;
	
	public double getDaysSurvived() {
		return daysSurvived;
	}

	public void setDaysSurvived(double daysSurvived) {
		this.daysSurvived = daysSurvived;
	}
	
	public void setCreature(ICreature creature) {
		this.creature = creature;
	}

	@Override
	public double getScore() {
		return daysSurvived;
	}

	@Override
	public ICreature getCreature() {
		return creature;
	}

	
}
