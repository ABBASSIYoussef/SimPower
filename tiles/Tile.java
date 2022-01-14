package tiles;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


/*
 *@class Tile
 *@@brief Classe représentant les tuiles d'arrière plan de la map
 */

public class Tile {
    protected BufferedImage image; //Image de la tuile
    protected TileType type; //Type de la tuile
    
	//Constructeur qui prend en parametre le type de la tuile et appelle le constructeur  à deux parametres en lui passant le type de la tuile passé en parametre et 0 en i


    public Tile(TileType t) { this(t, 0); }

    //-----------------------//

	//Constructeur qui prend en parametre le type de la tuile et son numéro pour l'indentifier.
    // ( les tuiles d'arriere plan sont nombreuses et on arrive à les distinguées en ajoutant un numéro à la fin. )
    // Exemple : la tuile river1 est la riviere vertical vers le bas tandis que la tuile river2 est la riviere horizental
    // le i en parametre represente le 1 dans river1 et 2 dans river2

    public Tile(TileType t, int i) {
    	type = t;
    	try {
			image = ImageIO.read(getClass().getResourceAsStream(TileType.tilePath(t, i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    //-----------------------//
}
