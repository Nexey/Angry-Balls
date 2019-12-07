package vues;

import java.util.Observable;
import java.util.Vector;

import modele.Bille;

/**
 * L'application contenant les données de base du jeu
 */
public abstract class Application extends Observable {
    public Vector<Bille> billes;
    
    public Application(Vector<Bille> billes) {
    	this.billes = billes;
    }
    
	public Vector<Bille> getBilles() {
		return billes;
	}
	
	protected void setBilles(Vector<Bille> billes) {
		this.billes = billes;
	}
	
	public void arreter(){
        System.exit(0);
    }
}
