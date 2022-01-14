package main;

import javax.swing.*;


/*
 *@class World
 *@@brief Classe définissant une fenetre de jeu
 */
public class World {

	private JFrame window;
	
	/**
 	 *@@brief Constructeur par défaut de la fenetre de jeu
	 *@return
	 *@param mapChoice int : index de la carte choisie
 	 */
	public World(int mapChoice) {

		window = new JFrame("SimPower 2021 Édition");
		Map map =  new Map(mapChoice);

		window.setResizable(false);
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		BoxLayout boxLayout = new BoxLayout(window.getContentPane(), BoxLayout.Y_AXIS); // top to bottom
		window.setLayout(boxLayout);

		window.add(map.statgraph);
		window.add(map);
		window.add(map.walletgraph);

		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
