package tiles;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *@class TileManager
 *@@brief Classe représentant la gestion des tuiles et les différentes fonctions qui aideront à faire l'affichage.
 */

public class TileManager {
    private Tile[] tile; // tableau de Tile, avec quoi on stockera les différents tiles possible.
    public int mapTileNum[][]; //Tableau à deux dimensions. Nous aide à avoir les coordonnées de chaque tuile afin de déterminer la tuile ou se passera l'action du joueur
    int colNb, rowNb, tileSize; //Attributs de parametres. colNb est le nombre de colonne max. de même pour rowNb ( nombre de lignes max ) . TileSize est la taille de la tuile ( 32x32)


    /**
     * @@brief unique constructeur de la classe
     * @param col : nombre de colonnes du tableau
     * @param row : nombr de rangs du tableau
     * @param ts : taille en pixel d'une tuile
     * @param mapChoice : carte s�lectionn�e
     */
    public TileManager(int col, int row, int ts, int mapChoice){
        //Constructeur avec quoi on stockera les différents tiles dans le tableau tile
        //permet d'instancier le tableau à deux dimensions. et mettre le bon parametrage des tuiles utilisées dans le jeu.
	    if(col>0 && row > 0 && ts > 0) {
    		tileSize = ts;
	        colNb = col;
	        rowNb = row;
	        tile = new Tile[31];
	        mapTileNum = new int[colNb][rowNb];
	        getTileImage();
	        if(mapChoice == 0) {
	        	loadMap("/assets/tiles.txt");
	        }else{
	        	loadMap("/assets/tiles2.txt");
	        }
	    }
    }
    
    /**
     *@@brief Méthode getTileImage servant d'instancier et stocker chaque tuile d'arrière plan dans le tableau Tile
     *@return void
     */
    public void getTileImage(){
        try{
        	// Assigne � chaque tuile son image
        	for (TileType t: TileType.values()) {
        		tile[TileType.tileIndex(t)] = new Tile(t);
        	}
            for (int i = 1; i < 8; i++) {
            	tile[TileType.tileIndex(TileType.RIVER, i)] = new Tile(TileType.RIVER, i);
            	tile[TileType.tileIndex(TileType.ROAD, i)] = new Tile(TileType.ROAD, i);
            }
        }catch(Exception e){

        }
    }
    
    /**
     *@@brief Méthode Main servant d'entrée au programme
        *Fonction qui prend en  parametre le chemin d'une matrice en .txt et la convertit en MAP affichable.
        *Elle lis la matrice est stock chaque numéro représentant le type de la tuile dans le tableau à deux dimensions.
        *Comme son nom l'indique, son boulot est de charger la map et la passer à la fonction qui la dessine.
     *@return void
     *@param String mapPath - le chemin du fichier text
     *
     */
    public void loadMap(String mapPath){
        try{
            InputStream is = getClass().getResourceAsStream(mapPath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col<colNb && row<rowNb){

                String line =  br.readLine();
                while(col<colNb){
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row]=num;
                    col++;

                }if(col == colNb){
                    col = 0; row++;
                }
            }
            br.close();
        }catch (Exception e ){

        }
    }

    /**
     *@@brief Méthode Main servant d'entrée au programme
     * Fonction qui dessine chaque tuile.
    * Elle arrive à faire l'affichage avec la fonction drawImage. fonction déjà existante en java.
    * Cette fonction est appelé dans paintComponent dans la class MAP.
     *@return void
     *@param Graphics2D g2 - moteur graphique
     *
     */
    public void draw(Graphics2D g2){
        try{
            int col= 0;
            int row=0;
            int x= 0;
            int y =0;
            while(col<colNb && row<rowNb){

                int tileNum = mapTileNum[col][row];

                g2.drawImage(tile[tileNum].image,x,y,tileSize,tileSize,null);
                col++;
                x+=tileSize;
                if(col==colNb){
                    col=0;
                    x=0;
                    row++;
                    y+=tileSize;
                }
            }
        }
        catch(NullPointerException e){

        }
    }
    
}
