package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class SolarPanel extends Producer {

	public SolarPanel()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/solarpanels.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Solar Panel";
		
		//Pollution
		dailyContamination = 0;
		
		//Prix
		price = 1000;
		
		//Bois requis
		woodNeeded = 200;
		
		//Pierre requise
		stoneNeeded = 200;
		
		//Energie produite
		energyProduced = 10;  // À MULTIPLIER PAR LE SOLEIL
		
		//Quantité ressource consommée
		quantityConsumed = 0;
		
		//Type de ressource consommée
		energyType = EnergyType.SUN;

		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;
		
	}
	
}
