package graphics;

import usefuls.*;
import javax.swing.*;
import java.awt.*;

/**
 * @class StatGraphics
 * @@brief Panneau contenant les stats du monde
 * @@brief ressources affich�es : nombre d'habitants, nombre maximal d'habitants, prix de l'�l�ctricit�, 
 * @@brief satisfaction des habitants, �nergie produite et n�cessaire, vent, soleil, pollution, nombre de jour
 */
public class StatGraphics extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Panneaux repr�sentant chacune des ressources affich�es dans le panneau global
	RessourcePanel satisfaction,nbHabitant,EP,ER,vent,sun,contamination, day, price;
    
	/**
	 * @@brief Constructeur de la classe
	 * @param w Wallet : Wallet � partir duque initialiser les valeurs de chaque panneau
	 */
	public StatGraphics(Wallet w){
		
		// Initialisation des param�tres du panneau global
        setPreferredSize(new Dimension(24*32,50));
        setBackground(new Color(215,215,215));
        
		// Initialisation des RessourcePanel
        ER = new RessourcePanel(RessourceEnum.ENERGYREQUIRED);
        satisfaction = new RessourcePanel(RessourceEnum.SMILEY);
        nbHabitant = new RessourcePanel(RessourceEnum.PERSON);
        EP = new RessourcePanel(RessourceEnum.ENERGYPRODUCED);
        vent = new RessourcePanel(RessourceEnum.WIND);
        sun = new RessourcePanel(RessourceEnum.SUN);
        contamination = new RessourcePanel(RessourceEnum.CONTAMINATION);
        day =new RessourcePanel(RessourceEnum.CALENDAR);
        price = new RessourcePanel(RessourceEnum.PRICE);

		// Ajout des RessourcePanel au panneau global
        add(satisfaction);
        add(nbHabitant);
        add(ER);
        add(EP);
        add(price);
        add(vent);
        add(sun);
        add(contamination);
        add(day);

        // mise � jour des valeurs des RessourcePanel selon les valeurs du Wallet
        update(w);
    }
	
	/**
 	 *@@brief Mise � jour des valeurs des RessourcePanel selon les valeurs du Wallet
	 *@return void
	 *@param Wallet w
 	 */
    public void update(Wallet w){
    	ER.resourceValue.setText("" + w.energyRequired);
        satisfaction.resourceValue.setText("" + w.satisfaction);
        nbHabitant.resourceValue.setText(w.habitants +"/"+w.habitantsMax);
        EP.resourceValue.setText("" + w.energyProduced);
        price.resourceValue.setText(""+ w.electricityPrice);
        vent.resourceValue.setText(""+w.wind);
        sun.resourceValue.setText(""+w.sun);
        contamination.resourceValue.setText("" + w.pollution);
        day.resourceValue.setText(""+w.day);
    }

}
