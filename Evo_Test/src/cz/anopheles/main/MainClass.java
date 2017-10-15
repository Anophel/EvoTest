package cz.anopheles.main;

import java.util.Arrays;
import java.util.Comparator;

import cz.anopheles.creature.api.ICreature;
import cz.anopheles.creature.model.CreatureSurvival;
import cz.anopheles.statistics.api.IResult;
import cz.anopheles.util.CreatureFactory;
import cz.anopheles.world.api.IWorld;
import cz.anopheles.world.model.WorldSurvive;

public class MainClass {

	public static void main(String[] args){
		System.out.println("Test of evolution simulation.");
		System.out.println("*****");
		
		IWorld world = new WorldSurvive();
		ICreature[] creatures = CreatureFactory.createSurvivalCreatures(100);
		
		for(ICreature crea : creatures){
			CreatureSurvival temp = (CreatureSurvival) crea;
			temp.setX(64);
			temp.setY(64);
		}
		
		world.initialize(creatures);
		world.run();
		
		System.out.println("\n" + world.getMap() + "\n");
		
		IResult[] results = world.getResults();
		Arrays.sort(results, new Comparator<IResult>() {

			@Override
			public int compare(IResult arg0, IResult arg1) {
				return (int) Math.signum(arg0.getScore()-arg1.getScore());
			}
			
		});
		for(int i = 0; i < results.length; i++){
			System.out.println("Creature " + i + " survived for " + results[i].getScore() +". To je borec...");
		}
		System.out.println("*****");
		System.out.println("Intro test ended");
		System.out.println("*****");
	}
}
