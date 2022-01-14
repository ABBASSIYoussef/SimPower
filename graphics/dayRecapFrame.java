package graphics;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import usefuls.Wallet;

/**
 *@class dayRecapFrame
 *@@brief Frame affichant le récap journalier pour chaque ressource
 *@@brief ressources affichées : bois, pierre, charbon, uranium, monnaie, prix de l'éléctricité, satisfaction des habitants, nombre d'habitants 
 */
public class dayRecapFrame extends JFrame {

	private static final long serialVersionUID = 1L;
    
	// Panneaux représentant chacune des ressources affichées dans la frame
	private RessourcePanel recapWood,recapStone,recapCoal, recapPrice, recapUranium,recapEuro, recapHab, recapSatis;

    
	public dayRecapFrame(){
    	
		// Initialisation des paramètres de la frame 
		setSize(50, 400);
    	setResizable(false);
    	BoxLayout layout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
    	setLayout(layout);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(false);
		
		// Initialisation des RessourcePanel
		recapWood = new RessourcePanel(RessourceEnum.WOOD);
		recapStone = new RessourcePanel(RessourceEnum.STONE);
		recapCoal = new RessourcePanel(RessourceEnum.COAL);
		recapUranium = new RessourcePanel(RessourceEnum.URANIUM);
		recapEuro = new RessourcePanel(RessourceEnum.EURO);
		recapHab = new RessourcePanel(RessourceEnum.PERSON);
		recapSatis = new RessourcePanel(RessourceEnum.SMILEY);
		recapPrice = new RessourcePanel(RessourceEnum.PRICE);

		// Ajout des RessourcePanel à la frame
		add(recapEuro);
    	add(recapWood);
    	add(recapStone);
    	add(recapCoal);
    	add(recapUranium);
    	add(recapHab);
    	add(recapPrice);
    	add(recapSatis);

	}
	
	/**
 	 *@@brief Mise à jour des panels de la frame de récap selon les valeurs journalières
	 *@return void
	 *@param Wallet former: Wallet à l'instant t-1
	 *@param Wallet w: Wallet à l'instant t
 	 */
	 public void dayRecapUpdate(Wallet former, Wallet w) {
    	recapEuro.resourceValue.setText("" + (w.money-former.money));
    	recapWood.resourceValue.setText("" + (w.wood-former.wood));
    	recapStone.resourceValue.setText("" + (w.stone-former.stone));
    	recapCoal.resourceValue.setText("" + (w.coal-former.coal));
    	recapUranium.resourceValue.setText("" + (w.uranium-former.uranium));
    	recapSatis.resourceValue.setText("" + (w.satisfaction-former.satisfaction));
    	recapPrice.resourceValue.setText("" + (w.electricityPrice-former.electricityPrice));
    	recapHab.resourceValue.setText("" + (w.habitants-former.habitants));
    }

}
