package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class WindTurbine extends Producer {

	public WindTurbine()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/windturbine.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Wind Turbine";
		
		//Pollution
		dailyContamination = 0;
		
		//Prix
		price = 1100;
		
		//Bois requis
		woodNeeded = 350;
		
		//Pierre requise
		stoneNeeded = 600;
		
		//Energie produite
		energyProduced = 15;  // À MULTIPLIER PAR LE VENT
		
		//Quantité ressource consommée
		quantityConsumed = 0;
		
		//Type de ressource consommée
		energyType = EnergyType.WIND;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
		
	}
	
}
