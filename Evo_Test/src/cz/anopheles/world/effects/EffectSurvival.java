package cz.anopheles.world.effects;

import cz.anopheles.creature.api.ICreature;
import cz.anopheles.creature.model.CreatureSurvival;
import cz.anopheles.util.CodeList;
import cz.anopheles.world.api.ILocationEffect;

public abstract class EffectSurvival implements ILocationEffect{

	@Override
	public boolean doEffect(ICreature creature) {
		if(creature.getCreatureType() != CodeList.CREATURE_TYPE_SURVIVAL)
			return false;
		
		CreatureSurvival creaSurvival = (CreatureSurvival) creature;
		
		doEffectInner(creaSurvival);
		
		return true;
	}
	
	protected abstract void doEffectInner(CreatureSurvival creaSurvival);
}
