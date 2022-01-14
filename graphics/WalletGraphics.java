package graphics;

import javax.swing.*;
import main.Map;
import usefuls.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class WalletGraphics
 * @@brief Panneau contenant les ressources du joueur à partir desquelles il peut acheter des bâtiments et produire de l'énergie
 * @@brief Contient également les deux boutons permettant d'ouvrir le magasin et de passer au jour suivant
 * @@brief ressources affichées : bois, pierre, charbon, uranium, monnaie
 */
public class WalletGraphics extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Panneaux représentant chacune des ressources affichées dans le panneau global
	RessourcePanel wood,stone,coal,uranium,euro;
    // Frame de récap journalier à afficher lorsque le bouton "jour suivant" est pressé
	dayRecapFrame recap;
	// Boutons "magasin" et "jour suivant"
    JButton shopButton, nextDayButton;
    
    public WalletGraphics(Map map){

		// Initialisation des paramètres du panneau global

        setPreferredSize(new Dimension(24*32,50));
        setBackground(new Color(215,215,215));

        // initialisation de la frame de récap journalier
        recap = new dayRecapFrame();
        
        // Initialisation du Bouton "magasin"
        shopButton = new JButton("Shop");
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mise à jour des boutons d'achats de bâtiments du shop 
            	map.shop.updateButtons(map);
            	// affichage du shop
            	map.shop.setVisible(true);
            }
        });
        
        // Initialisation du Bouton "magasin"
		nextDayButton = new JButton("Next Day");
		nextDayButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		    	// copie du wallet avant modification pour pouvoir les comparer
		    	Wallet formerWallet = new Wallet(map.w);
		    	
		    	// Actualisation des valeur s du wallet selon les bâtiments placés sur la carte
		        map.w.nextDay(map.objHouse, map.objProducer, map.objExtractor);
		       
		        // Actualisation des valeurs des panneaux de stats et de ressources et de la frame de récap
		        // selon les nouvelles valeurs de wallet
		        recap.dayRecapUpdate(formerWallet, map.w);
		        map.statgraph.update(map.w);
		        update(map.w);
		        
		        //Affichage de la frame de récap journalier
		        recap.setVisible(true);
		    }
		});
		
		// Initialisation des RessourcePanel
		wood = new RessourcePanel(RessourceEnum.WOOD);
		stone = new RessourcePanel(RessourceEnum.STONE);
		coal = new RessourcePanel(RessourceEnum.COAL);
		uranium = new RessourcePanel(RessourceEnum.URANIUM);
		euro = new RessourcePanel(RessourceEnum.EURO);
		
		// Ajout des RessourcePanel au panneau global
        add(wood);
        add(stone);
        add(coal);
        add(uranium);
        add(euro);
   
        // Ajout des boutons au panneau global
        add(shopButton);
        add(nextDayButton);
        
        // mise à jour des valeurs des RessourcePanel selon les valeurs du Wallet
        update(map.w);
    }
    
    /**
 	 *@@brief Mise à jour des valeurs des RessourcePanel selon les valeurs du Wallet
	 *@return void
	 *@param Wallet w
 	 */
    public void update(Wallet w){
        wood.resourceValue.setText("" +(w.wood));
        stone.resourceValue.setText("" + (w.stone));
        coal.resourceValue.setText(""+(w.coal));
        uranium.resourceValue.setText(""+(w.uranium));
        euro.resourceValue.setText(""+(w.money));
    }
}
