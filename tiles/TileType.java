package tiles;


/*
 *@enum TileType
 *@@brief Énumération contenant les différents types de tuiles
 * Elle permet de manipuler les tuiles et accéder à ses différents caractéristiques ( nom, path etc... )
 */
public enum TileType {
	GRASS,
	MOUNTAIN,
	TREE,
	RIVER,
	ROAD;
	/*
	 *@@brief Méthode tilePath servant de return le path de la tuile
	 *@return String
	 *@param TileType t - type de la tuile
	 */
	public static String tilePath(TileType t) {
		switch(t) {
			case RIVER, ROAD: return "/assets/" + tileName(t) + "1.png";
			default: return "/assets/" + tileName(t) + ".png";
		}
		
	}
	/*
	 *@@brief Méthode tileNAme servant de return le nom de la tuile
	 *@return String
	 *@param TileType t - type de la tuile
	 */
	public static String tileName(TileType t) {
		switch(t) {
			case GRASS: return "grass";
			case MOUNTAIN: return "mountain";
			case TREE: return  "tree";
			case RIVER: return  "river";
			case ROAD: return  "road";
			default: return  "grass";
		}
	}
	/*
	 *@@brief Méthode tilePAth servant de return le path de la tuile
	 *@return String
	 *@param TileType t - type de la tuile; int i -  numéro identifiant la tuile.
	 * le i passé en parametre sert à différencier entre les différents tuile d'arrière plan ( tuile vertical, horizental etc.. )
	 */
	public static String tilePath(TileType t, int i) {
		if(i < 1 || i > 7) {
			i = 1;
		}
		switch(t) {
			case RIVER: return "/assets/river" + i + ".png";
			case ROAD: return "/assets/road" + i + ".png";
			default : return tilePath(t);
		}
	}
	/*
	 *@@brief Méthode tileIndex servant de return l'index de la tuile. Cet index sera le même que celui dans le tableau qui stockera les différents tuiles d'arrière plan
	 *@return String
	 *@param TileType t - type de la tuile
	 */
	public static int tileIndex(TileType t) {
		switch(t) {
			case GRASS: return 0;
			case MOUNTAIN: return 1;
			case TREE: return 3;
			case RIVER: return 5;
			case ROAD: return 12;
			default: return 0;
		}
	}
	/*
	 *@@brief même méthode que celle presenté en haut, avec un parametre de plus qui sert à déterminer le type de tile ( river 1 ou 2 ou 3 ) et la stocker au bon index au tableau approprié
	 *@return String
	 *@param TileType t - type de la tuile, int i - index
	 */
	public static int tileIndex(TileType t, int i) {
		if(i < 1 || i > 7) {
			i = 1;
		}
		switch(t) {
			case RIVER, ROAD: return tileIndex(t) + i - 1;
			default : return tileIndex(t);
		}
	}
	/*
	 *@@brief Méthode typeFromIndex faisant l'opération inverse. Prend l'index et return le type de la tuile
	 *@return TileType
	 *@param int i - index.
	 */
	public static TileType typeFromIndex(int i) {
		switch(i) {
		 	case 0 : return GRASS;
		 	case 1 : return MOUNTAIN;
		 	case 3 : return TREE; 
		 	case 5, 6, 7, 8, 9, 10, 11: return RIVER;
		 	case 12, 13, 14, 15, 16, 17, 18 : return ROAD; 
		 	default : return ROAD;
		}
	}
}
