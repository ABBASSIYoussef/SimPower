package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class UraniumExtractor extends Extractor {

	public UraniumExtractor()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/uraniumextractor.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Uranium Extractor";
		
		//Pollution
		dailyContamination = 1;
		
		//Prix
		price = 1500;
		
		//Bois requis
		woodNeeded = 150;
		
		//Pierre requise
		stoneNeeded = 100;
		
		//Quantité de ressource produite
		dailyQuantity = 5;
		
		//Type de ressource collectée
		typeEnergyCollected = EnergyType.URANIUM;
		
		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.MOUNTAIN;
		
	}
}
