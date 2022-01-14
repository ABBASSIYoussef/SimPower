package usefuls;

import object.Consumer;
import object.Extractor;
import object.GameObject;
import object.Producer;

/**
 *@class Wallet
 *@@brief Classe représentant un portefeuille de jeu
 */
public class Wallet {
	public int wood,coal,stone,uranium,money; //Ressources
	public int day,sun,wind; //Nombre du jour, valeur de soleil, valeur de vent
	public int pollution,satisfaction,electricityPrice; //Valeur de pollution, satisfaction, prix de l'électricité
	public int energyProduced,energyRequired; //Énergie produite, énergie demandée
	public int habitants,habitantsMax; //Nombre d'habitants, nombre d'habitants maximum

	
	public Wallet(Consumer objHouse[]) {
		wood = 500;
		stone = 400;
		coal = 200;
		uranium = 0;
		money = 1000;
		satisfaction=50;
		day = 0;
		habitants = Calculator.calcHab(objHouse);
		habitantsMax = Calculator.calcMaxHab(objHouse);
		energyRequired = Calculator.calcEr(objHouse);
		energyProduced = 0;
		pollution = 0;
		sun = Calculator.calcSun();	
		wind = Calculator.calcWind();
		electricityPrice = 100;
	}
	
	public Wallet(Wallet w) {
		wood = w.wood;
		stone = w.stone;
		coal = w.coal;
		uranium = w.uranium;
		money = w.money;
		day = w.day;
		satisfaction=w.satisfaction;
		energyProduced = w.energyProduced;
		energyRequired = w.energyRequired;
		habitants = w.habitants;
		habitantsMax = w.habitantsMax;
		electricityPrice = w.electricityPrice;
	}

	/**
 	 *@@brief Méthode qui soustrait au portefeuille les ressources nécessaires à la création d'un objet ( si le portefeuille contient suffisament de ressources )
	 *@return boolean
	 *@param GameObject g - objet souhaité
 	 */
	
	public boolean buyObject(GameObject g) {
		if(money >= g.getprice() && wood >= g.getWoodNeeded() && stone >= g.getStoneNeeded()) {
			money -= g.getprice();
			wood -= g.getWoodNeeded();
			stone -= g.getStoneNeeded();
			return true;
		}else {return false;}
	}
	
	/**
 	 *@@brief Mise à jour des valeurs des RessourcePanel selon les valeurs du Wallet
	 *@return void
	 *@param Wallet w
 	 */   
    public void nextDay(Consumer objHouse[], Producer objProducer[], Extractor objExtractor[]){
        energyProduced=0;
        energyRequired=0;

        for(int i=0; i<50;i++){
            if(objExtractor[i]!=null){
                objExtractor[i].extract(this);
            }
            if(objProducer[i]!=null){
            	objProducer[i].produce(this);
            }
        }
        pollution = Calculator.calcPollution(objHouse, objProducer, objExtractor);
        wind = Calculator.calcWind();
        sun = Calculator.calcSun();
        energyRequired = Calculator.calcEr(objHouse);
        electricityPrice = Calculator.electricityPrice(energyProduced, energyRequired);

        boolean satisfied = Calculator.calcBonheur(this);
        int habDiff = Calculator.calcAddedHabitant(satisfied, satisfaction, objHouse);        
        Calculator.addHabitant(objHouse, habDiff);
        habitantsMax = Calculator.calcMaxHab(objHouse);
        habitants = Calculator.calcHab(objHouse);
        money += Calculator.calcPrime(satisfaction, habitants);
        day++;
    }

}
