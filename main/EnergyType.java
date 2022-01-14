package main;


/*
 *@enum EnergyType
 *@@brief Énumération contenant les différents types d'énergie du jeu
 */
public enum EnergyType {
	SUN,
	WIND,
	WATER,
	COAL,
	WOOD,
	URANIUM,
	STONE,
	FUSION;
	
	static public String toString(EnergyType e) {
			
		String type;
		switch(e) {
			case SUN: type = "Sun";
				break;
			case WIND: type = "Wind";
				break;
			case WATER: type = "Water";
				break;
			case COAL: type = "Coal";
				break;
			case WOOD: type = "Wood";
				break;
			case URANIUM: type = "Uranium";
				break;
			case STONE: type = "Stone";
				break;
			case FUSION: type = "Fusion";
				break;
			default: type = "None";
		}
		return type;
	}
}
