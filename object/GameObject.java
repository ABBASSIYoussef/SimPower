package object;

import java.awt.*;
import java.awt.image.BufferedImage;

import main.Map;
import tiles.TileType;

/*
 *@class GameObject
 *@brief Classe mère de tous les objets du jeu
 */
public abstract class GameObject {

	public BufferedImage image; //Image de l'objet
	public String name; //Nom de l'objet
	public int positionX = 0, positionY=0; //Position de l'objet
	public TileType tileTypeRequired;
	protected int dailyContamination; //Pollution générée par l'objet
	protected int price; // Prix de l'objet €
	protected int woodNeeded; // Cout en bois
	protected int stoneNeeded; //Cout en pierre

	
	/*
	 *@brief Méthode retournant la pollution générée quotidiennement
	 *@return int
	 *@param
	 */
	public int getDailyContamination(){return dailyContamination;}
	
	
	/*
	 *@brief Méthode retournant le prix de l'objet
	 *@return int
	 *@param
	 */
	public int getprice(){return price;}
	
	
	/*
	 *@brief Méthode retournant le bois nécessaire à la construction de l'objet
	 *@return int
	 *@param
	 */
	public int getWoodNeeded()
	{
		return woodNeeded;
	}
	
	/*
	 *@brief Méthode retournant la pierre nécessaire à la construction de l'objet
	 *@return int
	 *@param
	 */
	public int getStoneNeeded()
	{
		return stoneNeeded;
	}
	public void draw(Graphics2D g2, Map map){
		g2.drawImage(image,positionX,positionY,map.tileSize, map.tileSize,null );
	}


	/*
	 *@brief Méthode retournant les différentes informations de l'objet sous forme d'une chaine de caractères
	 *@return String
	 *@param
	 */
	public String toString()
	{
		return "\nName: " + name + "\nPrice: " + price + "\nWood: " + woodNeeded + "\nStone: " + stoneNeeded + "\nPlacement: " + TileType.tileName(tileTypeRequired);
	}
}
