package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class NuclearPowerPlant extends Producer{

	public NuclearPowerPlant()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/nuclearpowerplant.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Nuclear Power Plant";
		
		//Pollution
		dailyContamination = 5;
		
		//Prix
		price = 1700;
		
		//Bois requis
		woodNeeded = 750;
		
		//Pierre requise
		stoneNeeded = 850;
		
		//Energie produite
		energyProduced = 350;
		
		//Quantité ressource consommée
		quantityConsumed = 20;
		
		//Type de ressource consommée
		energyType = EnergyType.URANIUM;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
		
		
	}
}
