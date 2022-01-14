package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class CoalExtractor extends Extractor{
	
	public CoalExtractor()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/coalextractor.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Coal Extractor";
		
		//Pollution
		dailyContamination = 2;
		
		//Prix
		price = 750;
		
		//Bois requis
		woodNeeded = 90;
		
		//Pierre requise
		stoneNeeded = 70;
		
		//Quantité de ressource produite
		dailyQuantity = 20;
		
		//Type de ressource collectée
		typeEnergyCollected = EnergyType.COAL;
		
		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.MOUNTAIN;
	}
}
