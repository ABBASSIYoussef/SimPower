package usefuls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import main.Map;
import object.*;

/*
 *@class ShopButton
 *@@brief Classe héritant de JButton et repr�sentant les boutons du magasin
 */
public class ShopButton extends JButton {

	private static final long serialVersionUID = 1L;

	/**
	 * @@brief Unique constructeur de la classe
	 * @param building GameObject : Type de b�timent associ� au bouton
	 * @param map Map : Carte du jeu � laquelle ajouter des b�timents
	 * @param shop Shop : magasin
	 */
	public ShopButton(GameObject building, Map map, Shop shop) {
		
		setVisible(true);
		/**
		 * Action listener du bouton
		 * Ferme le magasin, puis v�rifie si le joueur peut acheter le b�timent associ�
		 * Si oui, instancie un b�timent du m�me type dans la case s�lectionn�e
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
	            		System.out.println("Extractor n°"+map.currentExtractorCount);
	            		
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
	            		System.out.println("Producer n°"+map.currentProducerCount);
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
	            		System.out.println("Consumer n°"+map.currentHouseCount);
	
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
	 * @@brief Mise � jour du label et de l'activation du bouton selon si le joueur peut le placer sur la case s�lectionn�e ou non
	 * @param map Map : Carte du jeu
	 * @param building GameObject : B�timent associ� au bouton
	 */
	public void update(Map map, GameObject building) {
		// V�rification que la case ne contienne pas d�j� un b�timent
		if(!map.isBuildable()) {
        	setText("Building in selected tile");
        	setEnabled(false);
        // V�rification que la case s�lectionn�e correspond au type de tuile requis pour le b�timent
        }else if (map.detectTileType(building)!=building.tileTypeRequired) {
        	setText("Can't be built here");
        	setEnabled(false);
    // V�rification des ressources disponibles du joueur
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
        	// Activation du bouton si le joueur peut placer un b�timent
        	setText("Buy");
        	setEnabled(true);
        }
	}
}
