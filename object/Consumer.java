package object;


public abstract class Consumer extends GameObject{

	protected int habMaxNB; //Nombre maximum d'habitants
	protected int habNB; //Nombre d'habitant
	protected int energyPerHab; //Energie consomm√©e par habitants
	
	
	/*
	 *@brief M√©thode retournant le nombre d'habitants maximal du batiment
	 *@return int
	 *@param
	 */
	public int getHabMaxNB(){return habMaxNB;}
	
	/*
	 *@brief M√©thode retournant le nombre d'habitant du batiment
	 *@return int
	 *@param
	 */
	public int getHabNB(){return habNB;}
	
	/*
	 *@brief Ajoute n habitants au b‚timents
	 *@return 
	 *@param entier ‡ ajouter
	 */
	public void setHabNB(int n){
		if(n+habNB <= habMaxNB && n+habNB >= 0) {
			habNB += n;
		}
	}
	
	public int getEnergyRequired() {
		return energyPerHab * habNB;
	}
	
	
	@Override
	public String toString(){
		return super.toString() + "\nMax hab: " + habMaxNB + "\nEnergy/hab: " + energyPerHab;
	}
}
