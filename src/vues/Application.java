package vues;

import java.util.Vector;

import modele.Bille;
import états.ContrôleurÉtat;

public abstract class Application {
	private ContrôleurÉtat controleurCourant;
    private Vector<Bille> billes;
    
    public Application(Vector<Bille> billes) {
    	this.billes = billes;
    }
    
	public Vector<Bille> getBilles() {
		return billes;
	}
	
	protected void setBilles(Vector<Bille> billes) {
		this.billes = billes;
	}
	
	public ContrôleurÉtat getControleurCourant() {
		return controleurCourant;
	}
	
	public void setControleurCourant(ContrôleurÉtat controleurCourant) {
		this.controleurCourant = controleurCourant;
	}
	
	public void arreter(){
        System.exit(0);
    }
}
