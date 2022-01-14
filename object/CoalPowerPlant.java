package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class CoalPowerPlant extends Producer{

	public CoalPowerPlant()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/coalpowerplant.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Coal Power Plant";
		
		//Pollution
		dailyContamination = 85;
		
		//Prix
		price = 700;
		
		//Bois requis
		woodNeeded = 150;
		
		//Pierre requise
		stoneNeeded = 150;
		
		//Energie produite
		energyProduced = 50;
		
		//Quantité ressource consommée
		quantityConsumed = 20;
		
		//Type de ressource consommée
		energyType = EnergyType.COAL;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
	}
}
