package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import tiles.TileType;

public class FutureSkyscraper extends Consumer {


	public FutureSkyscraper()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/house4.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Future Skyscraper";
		
		//Pollution
		dailyContamination = 10;
		
		//Prix
		price = 500;
		
		//Bois requis
		woodNeeded = 500;
		
		//Pierre requise
		stoneNeeded = 500;
		
		//Nombre d'habitant maximum
		habMaxNB = 100;
		
		//Énergie consommée par habitants
		energyPerHab = 1;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;		
		
	}
}
