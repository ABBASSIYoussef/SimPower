package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class Dam extends Producer{

	public Dam()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/barrage.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Dam";
		
		//Pollution
		dailyContamination = 20;
		
		//Prix
		price = 1000;
		
		//Bois requis
		woodNeeded = 300;
		
		//Pierre requise
		stoneNeeded = 400;
		
		//Energie produite
		energyProduced = 110;
		
		//Quantité ressource consommée
		quantityConsumed = 0;
		
		//Type de ressource consommée
		energyType = EnergyType.WATER;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.RIVER;
	}
}
