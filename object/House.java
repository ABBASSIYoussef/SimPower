package object;


import javax.imageio.ImageIO;
import tiles.TileType;

public class House extends Consumer {

	public House()
	{
		//Image
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/assets/house.png"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		//Nom
		name = "House";

		//Pollution
		dailyContamination = 1;

		//Prix
		price = 100;

		//Bois requis
		woodNeeded = 100;

		//Pierre requise
		stoneNeeded = 100;

		//Nombre d'habitant maximum
		habMaxNB = 6;

		//Énergie consommée par habitants
		energyPerHab = 1;
		
		// Tuile sur laquelle placer le b�timent
		tileTypeRequired = TileType.GRASS;

	}
	public House(int n){
		this();
		habNB=n;
	}
}
