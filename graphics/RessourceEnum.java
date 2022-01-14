package graphics;

/**
 *@enum RessourceEnum
 *@@brief Enumération représentant les différentes ressources à afficher dans le HUD
 */
public enum RessourceEnum {
	SMILEY,
	ENERGYPRODUCED,
	ENERGYREQUIRED,
	CONTAMINATION,
	PERSON,
	WIND,
	SUN,
	WOOD,
	STONE,
	COAL,
	URANIUM,
	EURO,
	CALENDAR,
	PRICE;
	
	/**
	 * @@brief 
	 * @param r RessourceEnum
	 * @return String : Chemin du sprite correspondant au type de ressource en paramètre
	 */
	static public String pathToRessource(RessourceEnum r) {
			
		String type;
		switch(r) {
			case SMILEY: type = "smiley";
				break;
			case ENERGYREQUIRED: type = "energyrequired";
				break;
			case ENERGYPRODUCED: type = "energyproduced";
				break;
			case CONTAMINATION: type = "contamination";
				break;
			case PERSON: type = "person";
				break;
			case EURO: type = "euro";
				break;
			case SUN: type = "sun";
				break;
			case WIND: type = "wind";
				break;
			case COAL: type = "coal";
				break;
			case WOOD: type = "wood";
				break;
			case URANIUM: type = "uranium";
				break;
			case STONE: type = "stone";
				break;
			case CALENDAR: type = "calendar";
				break;
			case PRICE: type = "price";
				break;
			default: type = "smiley";
		}
		return "/assets/" + type + ".png";
	}
}
