package cz.anopheles.util;

public class CodeList {

	public static int SIMULATION_NOT_READY = 0x1;
	public static int SIMULATION_READY = 0x2;
	public static int SIMULATION_RUNNING = 0x3;
	public static int SIMULATION_DONE = 0x4;
	
	public static int CREATURE_TYPE_SURVIVAL = 0x11;
	
	public static int MAP_NOT_INIT = 0x21;
	public static int MAP_INIT = 0x22;
	
	public static char LOCATION_TYPE_SURVIVAL_EAT = 'E';
	public static char LOCATION_TYPE_SURVIVAL_GATHER = 'G';
	public static char LOCATION_TYPE_SURVIVAL_STARVE = 'S';
}
