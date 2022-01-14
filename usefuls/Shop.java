package usefuls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Map;
import object.*;

/**
 *@class Shop
 *@@brief Classe héritant de JFrame permettant la création de la fenetre du magasin du jeu
 */
public class Shop extends JFrame{

	private static final long serialVersionUID = 1L;
	
	GameObject[] products; //Tableau contenant les objets pouvant êtres achetés
	JPanel[] list; //Tableau contanant les différents conteneurs du magasin
    JLabel[] img; //Tableau contenant les différentes images des objets pouvant êtres achetés
    JPanel contentPane; //Conteneur global de la fenetre
    ShopButton[] buttons; //Tableau contenant les différents boutons associés aux objets pouvant êtres achetés


    public Shop(Map map){

        super("SimPower - Shop");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(850, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        //Conteneur gÃ©nÃ©ral
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(new GridLayout(3,6));

        list = new JPanel[15];

        img = new JLabel[15];
        buttons = new ShopButton[15];

        products = new GameObject[15];
        products[0] = new WoodExtractor();
        products[1] = new StoneExtractor();
        products[2] = new CoalExtractor();
        products[3] = new UraniumExtractor();
        products[4] = new WoodPowerPlant();
        products[5] = new CoalPowerPlant();
        products[6] = new Dam();
        products[7] = new SolarPanel();
        products[8] = new WindTurbine();
        products[9] = new NuclearPowerPlant();
        products[10] = new FusionPowerPlant();
        products[11] = new House();
        products[12] = new Block();
        products[13] = new Skyscraper();
        products[14] = new FutureSkyscraper();
        
        String attributes[];
        for(int i = 0; i < 15; i++) {
        	buttons[i] = new ShopButton(products[i], map, this);
        
	        list[i] = new JPanel();
	        list[i].setPreferredSize(new Dimension(850,40));
	        list[i].setLayout(new BoxLayout(list[i], BoxLayout.Y_AXIS));
	        if((i%2)!=1){
	            list[i].setBackground(new Color(247,247,247));
	        }
	        else{
	            list[i].setBackground(new Color(192,255,173));
	        }
	        img[i] = new JLabel();
	        img[i].setIcon(new ImageIcon(products[i].image));
            list[i].add(img[i]);
            list[i].add(new JLabel(" "));
            attributes = products[i].toString().split("\n");
            for(int j = 0; j < attributes.length; j++) {
                list[i].add(new JLabel(attributes[j]));
            }
            list[i].add(new JLabel(" "));
            
            list[i].add(buttons[i]);
            contentPane.add(list[i]);
        }
        
        setVisible(false);

    }
    


	

/*
 *@@brief Méthode mettant à jour le texte des boutons en fonction de la case sélectionnée
 *@return void
 *@param Map map - map du jeu
 */
    public void updateButtons(Map map){
    	for(int i = 0; i< buttons.length; i++){
            buttons[i].update(map, products[i]);
        }
    }

}
