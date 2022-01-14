package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.TileType;

public class Block extends Consumer{


	public Block()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/house2.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Housing estate";
		
		//Pollution
		dailyContamination = 3;
		
		//Prix
		price = 200;
		
		//Bois requis
		woodNeeded = 200;
		
		//Pierre requise
		stoneNeeded = 200;
		
		//Nombre d'habitant maximum
		habMaxNB = 25;
		
		//Énergie consommée par habitants
		energyPerHab = 1;
		
		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
		
		
	}
}
