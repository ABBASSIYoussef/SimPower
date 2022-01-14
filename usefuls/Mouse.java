package usefuls;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import main.Map;


/*
 *@class Mouse
 *@@brief Classe implémentant l'interface MouseListener et permettant de récupérer & stocker les coordonnées du curseur de la souris lorsque l'utilisateur clique
 */
public class Mouse implements MouseListener {
    public int mouseX, mouseY; // position du curseur
    protected Map map; // instance de Map
    
    /**
     * @@brief unique constructeur
     * @param m Map : carte du jeu
     */
    public Mouse(Map m) {
    	mouseX = -1;
    	mouseY = -1;
    	map = m;
    }
    
    /**
     * @@brief Action effectu�e lors d'un clic gauche souris
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // R�cup�ration des coordonn�es du curseur
    	Point p = e.getPoint();
        mouseX= p.x;
        mouseY=p.y;
        
        // update des boutons de la map selon la nouvelle case s�lectionn�e
        if(map.shop.isVisible()) {
        	map.shop.updateButtons(map);
    	}
        // actualisation de la carte pour d�placer la case
        map.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
