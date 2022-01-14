package usefuls;


import java.util.Random;
import object.*;

/**
 *@class Calculator
 *@@brief Classe contenant toutes les méthodes permettant la mise à jour des statistiques et des données du jeu
 */
public class Calculator {
    
    /**
 	 *@@brief Méthode permettant de calculer le nombre d'habitants
	 *@return int
	 *@param Consumer objHouse[] - tableau contenant les habitations
 	 */ 
	public static int calcHab(Consumer objHouse[]){
	    int x=0;
	    // parcours du tableau des consommateurs 
	    for(int i=0;i<50;i++){
	        if(objHouse[i]!=null){
	            x+=objHouse[i].getHabNB();
	        }
	    }
	    return x;
	}
    
	 /**
 	 *@@brief Méthode permettant de calculer l'énergie produite
	 *@return int
	 *@param Producer objProducer[] - tableau contenant les batiments producteurs d'énergie 
	 *@param Wallet w - portefeuille
 	 */
    public static int calcEp(Producer objProducer[], Wallet w){
        w.energyProduced = 0;
    	for(int i=0;i<50;i++){
            if(objProducer[i]!=null){
                w = objProducer[i].produce(w);
            }
        }
        return w.energyProduced;
    }

    /**
 	 *@@brief Méthode permettant de calculer l'énergie requise en parcourant le tableau contenant les habitations
	 *@return int
     *@param Consumer objHouse[] - tableau contenant les habitations
 	 */
    public static int calcEr(Consumer objHouse[]){
        int x=0;
        for(int i=0; i<50;i++){
            if(objHouse[i]!= null){
                x+=objHouse[i].getEnergyRequired();
            }
        }
        return x;
    }    
    
    /**
 	 *@@brief Méthode permettant de génerer une valeur aléatoire entre deux entiers
	 *@return int
     *@param int min - borne minilum , int max - borne maximum
 	 */
    public static int genVal(int min,int max){
        Random r =  new Random();
        return r.nextInt(max-min)+min;
    }
   
    /**
 	 *@@brief Méthode permettant de génerer une valeur de vent aléatoire
	 *@return int
     *@param
 	 */
    public static int calcWind(){
         return genVal(1,4);
    }
    
    /**
 	 *@@brief Méthode permettant de génerer une valeur de soleil aléatoire
	 *@return int
     *@param
 	 */
    public static int calcSun(){
        return genVal(1,5);
    }
    
    /**
  	 *@@brief Méthode permettant de mettre à jour la pollution en parcourant le tableau contenant les habitations, le tableau contenant les extracteurs et le tableau contenant les batiments producteurs d'énergie
 	 *@return int
      *@param Consumer objHouse[] - tableau contenant les habitations , Producer objProducer[] - tableau contenant les batiments producteurs d'énergie ,  Extractor objExtractor[] - tableau contenant les extracteurs
  	 */
    public static int calcPollution(Consumer objHouse[], Producer objProducer[], Extractor objExtractor[]){
        int x=0;
        for(int i=0; i<50;i++){
            if(objHouse[i]!=null){
                x+=objHouse[i].getDailyContamination();
            }if(objProducer[i]!=null){
                x+=objProducer[i].getDailyContamination();
            }if(objExtractor[i]!=null){
                x+=objExtractor[i].getDailyContamination();
            }
        }
        return x;
    }
    
    /**
 	 *@@brief Méthode permettant de calculer le nombre maximum d'habitants en parcourant le tableau contenant les habitations
	 *@return int
     *@param Consumer objHouse[] - tableau contenant les habitations
 	 */
    public static int calcMaxHab(Consumer objHouse[]){
        int x=0;
        for(int i=0; i<50;i++){
            if(objHouse[i]!=null){
                x+=objHouse[i].getHabMaxNB();
            }
        }
        return x;
    }
    
    /**
 	 *@@brief Méthode permettant de calculer le bonheur en prenant en compte l'énergie requise, l'énergie produite, le prix de l'électricité, la pollution et la surpopulation
	 *@return boolean
     *@param Wallet w - portefeuille
 	 */  
    public static boolean calcBonheur(Wallet w){

    	int satisfied = 0;
        if((w.energyProduced<w.energyRequired)){satisfied -= 1;}
        else {satisfied+=1;}
        
        if(w.pollution>(w.habitants+1)*10) {satisfied -= 1;}
        else if(w.pollution<(w.habitants+1)*2) { satisfied += 1;}
        
        if(w.habitants>=w.habitantsMax*0.9) {satisfied -= 3;}
        
        if(w.electricityPrice > 70) { satisfied -= 1;}
        else if(w.electricityPrice < 30) {satisfied += 1;}
        
        w.satisfaction += satisfied;
        
        if(w.satisfaction>100){w.satisfaction=100;}
        if(w.satisfaction<0){w.satisfaction=0;}
        
        return satisfied>0;
    }
    
    
    /**
 	 *@@brief Méthode permettant de calculer la prime versée au joueur en fonction du bonheur de la population et du nombre d'habitants
	 *@return int
     *@param int satisfaction - bonheur , int habNB - nombre d'habitants
 	 */ 
    public static int calcPrime(int satisfaction, int habNB){
        if (habNB*satisfaction/10 > 100) {
        	return (int) habNB*satisfaction/10;
        }else {
        	return 100;
        }
    }
    
    /**
   	 *@@brief Méthode permettant de calculer le prix de l'électricité en fonction de l'offre et de la demande
  	 *@return int
  	 *@param int offre - offre 
  	 *@param int demande - demande
   	 */ 
    public static int electricityPrice(int offre, int demande) {
    	if (offre !=0) {
    		return (int) 100*demande/(demande+offre);
    	}else {return 100;}
    }

    /**
 	 *@@brief Méthode permettant d'ajouter un nombre donné d'habitants en parcourant le tableau des habitations
	 *@return void
     *@param Consumer objHouse[] - tableau contenant les habitations 
     *@param int count - nombre d'habitants à ajouter
 	 */ 
    public static void addHabitant(Consumer objHouse[],int count){
        int habNB, maxHab, diff;
    	for(int j=0;j<50;j++){
            if(objHouse[j]!=null){
            	habNB = objHouse[j].getHabNB();
            	maxHab = objHouse[j].getHabMaxNB();
                if(count>0){
                    if(habNB != maxHab){
                        diff = Math.min(maxHab-habNB, count);
                        objHouse[j].setHabNB(diff);
                        count -= diff;
                    }
                }else {
                	if(habNB != 0){
                        diff = Math.max(-habNB, count);
                        objHouse[j].setHabNB(diff);
                        count -= diff;
                    }
                }
            }
        }
    }
    
    
    /**
 	 *@@brief Méthode permettant de définir le nombre d'habitants à ajouter en fonction de la satisfaction
	 *@return int
     *@param boolean satisfied - 
     *@param int satisfaction - bonheur
     *@param Consumer objHouse[] - tableau contenant les habitations
 	 */ 
    public static int calcAddedHabitant(boolean satisfied, int satisfaction, Consumer objHouse[]){
        // Ajoute des habitants si les habitants sont globalement satisfaits, en retire sinon
    	if (satisfied) {
        	return (int)satisfaction*calcMaxHab(objHouse)/300;
        }else {
        	return (int)-(100-satisfaction)*calcHab(objHouse)/300;
        }
    }

}
