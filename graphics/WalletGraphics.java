package graphics;

import javax.swing.*;
import main.Map;
import usefuls.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @class WalletGraphics
 * @@brief Panneau contenant les ressources du joueur � partir desquelles il peut acheter des b�timents et produire de l'�nergie
 * @@brief Contient �galement les deux boutons permettant d'ouvrir le magasin et de passer au jour suivant
 * @@brief ressources affich�es : bois, pierre, charbon, uranium, monnaie
 */
public class WalletGraphics extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Panneaux repr�sentant chacune des ressources affich�es dans le panneau global
	RessourcePanel wood,stone,coal,uranium,euro;
    // Frame de r�cap journalier � afficher lorsque le bouton "jour suivant" est press�
	dayRecapFrame recap;
	// Boutons "magasin" et "jour suivant"
    JButton shopButton, nextDayButton;
    
    public WalletGraphics(Map map){

		// Initialisation des param�tres du panneau global

        setPreferredSize(new Dimension(24*32,50));
        setBackground(new Color(215,215,215));

        // initialisation de la frame de r�cap journalier
        recap = new dayRecapFrame();
        
        // Initialisation du Bouton "magasin"
        shopButton = new JButton("Shop");
        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mise � jour des boutons d'achats de b�timents du shop 
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
		    	
		    	// Actualisation des valeur s du wallet selon les b�timents plac�s sur la carte
		        map.w.nextDay(map.objHouse, map.objProducer, map.objExtractor);
		       
		        // Actualisation des valeurs des panneaux de stats et de ressources et de la frame de r�cap
		        // selon les nouvelles valeurs de wallet
		        recap.dayRecapUpdate(formerWallet, map.w);
		        map.statgraph.update(map.w);
		        update(map.w);
		        
		        //Affichage de la frame de r�cap journalier
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
        
        // mise � jour des valeurs des RessourcePanel selon les valeurs du Wallet
        update(map.w);
    }
    
    /**
 	 *@@brief Mise � jour des valeurs des RessourcePanel selon les valeurs du Wallet
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
