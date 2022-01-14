package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class FusionPowerPlant extends Producer{
	
	public FusionPowerPlant()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/fusionpowerplant.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Fusion Power Plant";
		
		//Pollution
		dailyContamination = 5;
		
		//Prix
		price = 2500;
		
		//Bois requis
		woodNeeded = 1000;
		
		//Pierre requise
		stoneNeeded = 1000;
		
		//Energie produite
		energyProduced = 800;
		
		//Quantité ressource consommée
		quantityConsumed = 5;
		
		//Type de ressource consommée
		energyType = EnergyType.URANIUM;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
		
	}
}
