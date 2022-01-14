package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.TileType;

public class Skyscraper extends Consumer{

	

	public Skyscraper()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/house3.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Skyscraper";
		
		//Pollution
		dailyContamination = 10;
		
		//Prix
		price = 240;
		
		//Bois requis
		woodNeeded = 240;
		
		//Pierre requise
		stoneNeeded = 240;
		
		//Nombre d'habitant maximum
		habMaxNB = 60;
		
		//Énergie consommée par habitants
		energyPerHab = 2;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
		
	}
}
