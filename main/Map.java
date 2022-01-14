package main;

import graphics.*;
import object.*;
import tiles.TileManager;
import usefuls.*;
import javax.swing.*;
import java.awt.*;
import tiles.TileType;

/*
 *@class Map
 *@@brief Classe permettant la création d'une map ( map comprise dans un objet de type World )
 */
public class Map extends JPanel  {


	private static final long serialVersionUID = 1L;
	public final int screenHeight = 18*32, screnWidth = 24*32; //Taille de la map en pixels
	public final int maxScreenCol = 24; //Nombre de colones de tuiles
	public final int maxScreenRow = 18; //Nombre de lignes de tuiles
	public final int tileSize = 32; //Taille d'une tuile en pixels
	public  Graphics2D g1;
	public Mouse souris; //Déclaration d'un nouvel objet de type Mouse ( dans le but de récuperer les coordonnées du curseur de la souris )
	public int currentHouseCount =0; //Nombre de maisons construites
	public int currentExtractorCount=0; //Nombre d'extracteurs construits
	public int currentProducerCount=0; //Nombre de batiments producteurs d'énergie construits
	public Wallet w; //Déclaration d'un nouveau portefeuille
	public Shop shop; //Déclaration d'un nouveau magasin
	public WalletGraphics walletgraph; //Déclaration d'une fenetre de portefeuille
	public Calculator calculator ; //Déclaration d'un nouvel objet de type Calculator
	public StatGraphics statgraph ; //Déclaration d'une nouvelle fenetre de statistiques
	TileManager tileManager; //Déclaration d'un nouveau gestionnaire de tuiles
	public Consumer[] objHouse; //Tableau contenant les batiments de type habitations
	public Extractor[] objExtractor; //Tableau contenant les extracteurs de ressources
	public Producer[] objProducer; //Tableau contenant les batiments producteurs d'énergie

	
	
	/**
 	 *@@brief Constructeur par défaut d'une Map
	 *@return
	 *@param mapChoice int : choix de la carte
 	 */
	public Map(int mapChoice) {
		souris = new Mouse(this);
		this.setPreferredSize(new Dimension(screnWidth,screenHeight));
		this.setBackground(Color.white);
		this.setDoubleBuffered(true);
		this.addMouseListener(souris);	
		
		tileManager = new TileManager(maxScreenCol, maxScreenRow, tileSize, mapChoice);
		objHouse =  new Consumer[50];
		objExtractor = new Extractor[50];
		objProducer =  new Producer[50];		
		
		setUpGame(mapChoice);
		w =  new Wallet(objHouse);
		
		walletgraph = new WalletGraphics(this);
		calculator = new Calculator();
		statgraph =  new StatGraphics(w);
		shop = new Shop(this);

	}
	
	
	/**
 	 *@@brief Méthode permettant d'ajouter les maisons de base
	 *@return void
	 *@param mapChoice int : index de la map 
 	 */
	public void setUpGame(int mapChoice){
		try{
			if (mapChoice == 1) {
				setHouse(11, 8);
				setHouse(12, 8);
				setHouse(11, 9);
				setHouse(12, 9);
			}else {
				setHouse(10,10);
		        setHouse(10,11);
		        setHouse(11,10);
		        setHouse(11,11);
			}
        }
        catch(NullPointerException e){
            System.out.println("erreur");
        }
	}
	
	

	/**
 	 *@@brief Méthode permettant d'ajouter une maison
	 *@return void
	 *@param int x , int y - colonne et ligne associées
 	 */
	public void setHouse(int x, int y) {
    	objHouse[currentHouseCount] = new House(3);
        objHouse[currentHouseCount].positionX= x*tileSize;
        objHouse[currentHouseCount].positionY =  y*tileSize;
        currentHouseCount++;
    }
	

	/**
 	 *@@brief Méthode permettant de renvoyer le type de tuile compatible avec un objet donné
	 *@return TileType
	 *@param GameObject go - objet dont on veut connaitre le type de tuile compatible
 	 */
	public TileType detectTileType(GameObject go){
		if (go.positionY == 0 && go.positionX == 0) {
			int x = (((int) (souris.mouseX)) / 32);
			int y= (((int) (souris.mouseY)) / 32);
			return TileType.typeFromIndex(tileManager.mapTileNum[x][y]);
		}else{
			return go.tileTypeRequired;
		}

	}


	public void checkObjCord(GameObject go){
		int TileX, TileY;
		if (go.positionY == 0 && go.positionX == 0) {
			TileX = (((int) (souris.mouseX)) / 32);
			TileY = (((int) (souris.mouseY)) / 32);

			go.positionX = TileX * 32;
			go.positionY = TileY * 32;
		}
	}

	
	/**
 	 *@@brief Méthode permettant de dessiner un objet
	 *@return void
	 *@param GameObject go - objet à dessiner , Graphics2D g2
 	 */
	public void drawObject(GameObject go,Graphics2D g2){
		if(go !=null) {
			if (detectTileType(go)==go.tileTypeRequired){
				checkObjCord(go);
				go.draw(g2,this);
			}
		}
	}
	
	/**
 	 *@@brief Méthode permettant de dessiner le selecteur de case ( carré rouge )
	 *@return void
	 *@param Graphics g2
 	 */
	public void drawMouse(Graphics g2) {
		int x = (((int) (souris.mouseX)) / 32)*32;
		int y= (((int) (souris.mouseY)) / 32)*32;
		g2.setColor(new Color(188,27,27,150));
		g2.fillRect(x, y, tileSize, tileSize);
	}

	
	/**
 	 *@@brief Méthode permettant de savoir si la tuile aux dernières coordonnées selectionnées est constructible ou non
	 *@return boolean
	 *@param
 	 */
	public boolean isBuildable(){
		int x = (((int) (souris.mouseX)) / 32)*32;
		int y= (((int) (souris.mouseY)) / 32)*32;
		return (!containObject(objHouse, x, y) && !containObject(objExtractor, x, y) && !containObject(objProducer, x, y));
	}
	
	
	
	/**
 	 *@@brief Méthode permettant de vérifier si la case sélectionnée contient un objet ou non
	 *@return boolean
	 *@param GameObject List[] - tableau contenant tous les objets , int x , int y - coordonnées cibles
 	 */
	public boolean containObject(GameObject list[], int x, int y) {
		for(int i=0; i<50;i++){
			if(list[i]!=null && list[i].positionX==x && list[i].positionY==y){
				return true;
			}
		}
		return false;
	}
	
	
	
	/**
 	 *@@brief Méthode permettant de dessiner la Map
	 *@return void
	 *@param Graphics g
 	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		//Tile
		tileManager.draw(g2);

		for(int i=0;i<50;i++){
			if(objHouse[i]!=null){
				drawObject(objHouse[i],g2 );
			}
			if(objExtractor[i]!=null){
				drawObject(objExtractor[i],g2 );
			}
			if(objProducer[i]!=null){
				drawObject(objProducer[i],g2 );
			}
		}
		drawMouse(g2);
		
		g2.dispose();
	}
}
