package graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

/**
 *@class RessourcePanel
 *@@brief Panneau contenant une image et la valeur associée à cette image 
 */
public class RessourcePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Label contenant l'image du panneau 
	private JLabel resourceIcon; 
	// Label contenant la valeur du panneau
	protected JLabel resourceValue;
	
	/**
	 * @@brief Constructeur de la classe
	 * @param r RessourceEnum
	 * @return 
	 */
	public RessourcePanel(RessourceEnum r)
	{
		// Initialisation des paramètres du panneau
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setBackground(new Color(215,215,215));

		// initialisation des attributs
		resourceIcon = new JLabel();
		resourceValue = new JLabel();
		
		// Récupération de l'image du panneau
		try {
			resourceIcon.setIcon(new ImageIcon(getClass().getResource(RessourceEnum.pathToRessource(r))));
		}catch(Exception e) {
			System.out.println("Image at path "+RessourceEnum.pathToRessource(r)+" not found");
		}
		
		// Ajout de l'icone et du label au panneau
		this.add(resourceIcon);
		this.add(resourceValue);
	}
	
}
