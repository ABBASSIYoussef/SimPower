package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class StoneExtractor extends Extractor {
	
	public StoneExtractor()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/stoneextractor.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Stone Extractor";
		
		//Pollution
		dailyContamination = 1;
		
		//Prix
		price = 800;
		
		//Bois requis
		woodNeeded = 50;
		
		//Pierre requise
		stoneNeeded = 60;
		
		//Quantité de ressource produite
		dailyQuantity = 15;
		
		//Type de ressource collectée
		typeEnergyCollected = EnergyType.STONE;
		
		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.MOUNTAIN;
	}
}
