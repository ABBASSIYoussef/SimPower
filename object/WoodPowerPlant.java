package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class WoodPowerPlant extends Producer{

	
	public WoodPowerPlant()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/woodpowerplant.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Wood Power Plant";
		
		//Pollution
		dailyContamination = 150;
		
		//Prix
		price = 600;
		
		//Bois requis
		woodNeeded = 80;
		
		//Pierre requise
		stoneNeeded = 60;
		
		//Energie produite
		energyProduced = 30;
		
		//Quantité ressource consommée
		quantityConsumed = 20;
		
		//Type de ressource consommée
		energyType = EnergyType.WOOD;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
	}
}
