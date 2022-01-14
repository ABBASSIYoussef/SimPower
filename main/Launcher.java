package main;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *@class Launcher
 *@@brief Classe hÃ©ritant de JFrame permettant la crÃ©ation de la page d'accueil du jeu
 */
public class Launcher extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel backgroundImage; //Image de fond
	JComboBox<String> mapChoice; // Liste déroulante permettant de choisir la map
	JButton playButton; //Bouton de lancement d'une nouvelle partie
	World game; //DÃ©claration d'une nouvelle partie
    
    
	/**
 	 *@@brief Constructeur par dÃ©faut de la page d'accueil
	 *@return
	 *@param
 	 */
	public Launcher()
	{
		// Initialisation de la fenêtre
		super("SimPower 2021 Edition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720,480);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Initialisation de l'image de fond
		backgroundImage = new JLabel();
		backgroundImage.setIcon(new ImageIcon(getClass().getResource("/assets/Menu.png")));
		backgroundImage.setSize(new Dimension(720,407));
		
		// Initialisation de la liste déroulante
		String[] maps = new String[]{"Arcadia Bay","Dunwall"};
		mapChoice = new JComboBox<String>(maps);
	    mapChoice.setBounds(new Rectangle(21, 92, 130, 25));
	    
		
	    // initialisation du bouton jouer
		playButton = new JButton("PLAY GAME");
		playButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            	//Lancement fenetre de jeu
            	game = new World(mapChoice.getSelectedIndex());
            }
        });
		
		add(backgroundImage);
		add(new JLabel("Map : "));
		add(mapChoice);
		add(playButton);

		
	
		this.setVisible(true);
		
	}
	
}
