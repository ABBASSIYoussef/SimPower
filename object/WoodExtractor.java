package object;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.EnergyType;
import tiles.TileType;

public class WoodExtractor extends Extractor{

	public WoodExtractor()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/woodextractor.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		//Nom
		name = "Wood Extractor";
		
		//Pollution
		dailyContamination = 1;
		
		//Prix
		price = 500;
		
		//Bois requis
		woodNeeded = 20;
		
		//Pierre requise
		stoneNeeded = 30;
		
		//Quantité de ressource produite
		dailyQuantity = 15;
		
		//Type de ressource collectée
		typeEnergyCollected = EnergyType.WOOD;
		
		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.TREE;
	}
}
