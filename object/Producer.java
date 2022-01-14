package object;

import main.EnergyType;
import usefuls.Wallet;

/*
 *@class Producer
 *@brief Classe mère de tous les batiments générateurs de ressources ( centrales, éoliennes, etc )
 */
public abstract class Producer extends GameObject{

	protected int energyProduced; // Energie produite
	protected int quantityConsumed; // Energie consommée
	protected EnergyType energyType; //Type d'énergie  consommée
	
	
	/*
	 *@brief Méthode retournant l'énergie produite quotidiennement
	 *@return int
	 *@param
	 */
	public int getEnergyProduced(){return energyProduced;}
	
	
	/*
	 *@brief Méthode retournant la quantité de ressource consommée
	 *@return int
	 *@param
	 */
	public int getQuantityConsumed(){return quantityConsumed;}
		
	
	/*
	 *@brief Méthode retournant le type de resource consommée
	 *@return EnergyType
	 *@param
	 */
	public EnergyType getEnergyType(){return energyType;}
	
	@Override
	public String toString(){
		return super.toString() + "\nResource used: " + EnergyType.toString(energyType) + "\nProd/day: " +energyProduced+"\nConsumption/day: " + quantityConsumed;
	}
	
	public Wallet produce(Wallet w) {
		switch(energyType) {
			case COAL: 
				if (w.coal>=quantityConsumed) {
					w.coal -= quantityConsumed;
					w.energyProduced += energyProduced;
				}
				break;
			case WOOD:
				if (w.wood>=quantityConsumed) {
					w.wood -= quantityConsumed;
					w.energyProduced += energyProduced;
				}
				break;
			case URANIUM:
				if (w.uranium>=quantityConsumed) {
					w.uranium -= quantityConsumed;
					w.energyProduced += energyProduced;
				}
				break;
			case FUSION: w.energyProduced += energyProduced;
			case WIND, WATER: w.energyProduced += w.wind * energyProduced;
				break;
			case SUN: w.energyProduced += w.sun * energyProduced; 
			default:
		}
		return w;
	}
	
}
