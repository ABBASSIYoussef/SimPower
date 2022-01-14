package object;

import main.EnergyType;
import usefuls.Wallet;

/*
 *@class Extractor
 *@brief Classe mère de tous les extracteurs de ressources 
 */
public abstract class Extractor extends GameObject{

	protected int dailyQuantity; //Quantité générée quotidiennement
	protected EnergyType typeEnergyCollected; // Type de ressource générée
	
	@Override
	public String toString(){
		return super.toString() + "\nResource collected: " + EnergyType.toString(typeEnergyCollected) + "\nCollect/day: " + dailyQuantity;
	}
	/*
	 *@brief Méthode retournant la quantité de ressource générée quotidiennement
	 *@return int
	 *@param
	 */
	public int getDailyQuantity(){ return dailyQuantity;}
	
	/*
	 *@brief Méthode retournant le type de ressource générée
	 *@return EnergyType
	 *@param
	 */
	public EnergyType getTypeEnergyCollected(){return typeEnergyCollected;}
	
	public Wallet extract(Wallet w) {
		switch(typeEnergyCollected) {
			case COAL: w.coal += dailyQuantity;
				break;
			case WOOD: w.wood += dailyQuantity;
				break;
			case URANIUM: w.uranium += dailyQuantity;
				break;
			case STONE: w.stone += dailyQuantity;
				break;
			default:
		}
		return w;
	}
}