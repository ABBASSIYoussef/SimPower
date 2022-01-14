package usefuls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import main.Map;
import object.*;

/*
 *@class ShopButton
 *@@brief Classe hÃ©ritant de JButton et représentant les boutons du magasin
 */
public class ShopButton extends JButton {

	private static final long serialVersionUID = 1L;

	/**
	 * @@brief Unique constructeur de la classe
	 * @param building GameObject : Type de bâtiment associé au bouton
	 * @param map Map : Carte du jeu à laquelle ajouter des bâtiments
	 * @param shop Shop : magasin
	 */
	public ShopButton(GameObject building, Map map, Shop shop) {
		
		setVisible(true);
		/**
		 * Action listener du bouton
		 * Ferme le magasin, puis vérifie si le joueur peut acheter le bâtiment associé
		 * Si oui, instancie un bâtiment du même type dans la case sélectionnée
		 */
		addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shop.setVisible(false);                    
                if(map.w.buyObject(building)){
                	if(building instanceof Extractor) {
	            		if(building instanceof WoodExtractor) {
	                		map.objExtractor[map.currentExtractorCount]=new WoodExtractor();
	            		}else if(building instanceof StoneExtractor) {
	                		map.objExtractor[map.currentExtractorCount]=new StoneExtractor();
	            		}else if(building instanceof CoalExtractor) {
	                		map.objExtractor[map.currentExtractorCount]=new CoalExtractor();
	            		}else if(building instanceof UraniumExtractor) {
	                		map.objExtractor[map.currentExtractorCount]=new UraniumExtractor();
	            		}
	            		map.currentExtractorCount+=1;
	            		System.out.println("Extractor nÂ°"+map.currentExtractorCount);
	            		
	            	}else if(building instanceof Producer){
	            		if(building instanceof CoalPowerPlant) {
	                		map.objProducer[map.currentProducerCount]=new CoalPowerPlant();
	            		}else if(building instanceof NuclearPowerPlant) {
	                		map.objProducer[map.currentProducerCount]=new NuclearPowerPlant();
	            		}else if(building instanceof WoodPowerPlant) {
	                		map.objProducer[map.currentProducerCount]=new WoodPowerPlant();
	            		}else if(building instanceof Dam) {
	                		map.objProducer[map.currentProducerCount]=new Dam();
	            		}else if(building instanceof WindTurbine) {
	                		map.objProducer[map.currentProducerCount]=new WindTurbine();
	            		}else if(building instanceof SolarPanel) {
	                		map.objProducer[map.currentProducerCount]=new SolarPanel();
	              		}else if(building instanceof FusionPowerPlant) {
	                		map.objProducer[map.currentProducerCount]=new FusionPowerPlant();
	            		}
	            		map.currentProducerCount += 1;
	            		System.out.println("Producer nÂ°"+map.currentProducerCount);
	            	}else if(building instanceof Consumer){
	            		if(building instanceof Block) {
	                		map.objHouse[map.currentHouseCount]=new Block();
	            		}else if(building instanceof FutureSkyscraper) {
	                		map.objHouse[map.currentHouseCount]=new FutureSkyscraper();
	            		}else if(building instanceof House) {
	                		map.objHouse[map.currentHouseCount]=new House();
	            		}else if(building instanceof Skyscraper) {
	                		map.objHouse[map.currentHouseCount]=new Skyscraper();
	            		}
	            		map.currentHouseCount += 1;
	            		System.out.println("Consumer nÂ°"+map.currentHouseCount);
	
	            	}
                	// Update de l'affichage du monde selon les nouveaux changements
	            	map.walletgraph.update(map.w);
	                map.repaint();
                }	
            }
    	});
		// Initialise le label et l'activation du bouton
		update(map, building);
    }

	/**
	 * @@brief Mise à jour du label et de l'activation du bouton selon si le joueur peut le placer sur la case sélectionnée ou non
	 * @param map Map : Carte du jeu
	 * @param building GameObject : Bâtiment associé au bouton
	 */
	public void update(Map map, GameObject building) {
		// Vérification que la case ne contienne pas déjà un bâtiment
		if(!map.isBuildable()) {
        	setText("Building in selected tile");
        	setEnabled(false);
        // Vérification que la case sélectionnée correspond au type de tuile requis pour le bâtiment
        }else if (map.detectTileType(building)!=building.tileTypeRequired) {
        	setText("Can't be built here");
        	setEnabled(false);
    // Vérification des ressources disponibles du joueur
        // Argent
        }else if(map.w.money < building.getprice()) {
        	setText("Not enough Money");
        	setEnabled(false);
        // Bois
        }else if(map.w.wood < building.getWoodNeeded()) {
        	setText("Not enough Wood");
        	setEnabled(false);
        //Pierre
        }else if(map.w.stone < building.getStoneNeeded()) {
        	setText("Not enough Stone");
        	setEnabled(false);
        }else {
        	// Activation du bouton si le joueur peut placer un bâtiment
        	setText("Buy");
        	setEnabled(true);
        }
	}
}
