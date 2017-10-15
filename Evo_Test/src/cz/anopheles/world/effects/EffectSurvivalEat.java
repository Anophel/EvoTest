package cz.anopheles.world.effects;

import cz.anopheles.creature.model.CreatureSurvival;
import cz.anopheles.util.CodeList;

public class EffectSurvivalEat extends EffectSurvival{

	@Override
	protected void doEffectInner(CreatureSurvival creaSurvival) {
		if(creaSurvival.getFoodInStock() > 1){
			creaSurvival.setFoodInStock(creaSurvival.getFoodInStock() - 1);
			creaSurvival.setHunger(creaSurvival.getHunger() + 1);
		}
	}

	@Override
	public char getType() {
		return CodeList.LOCATION_TYPE_SURVIVAL_EAT;
	}

}
