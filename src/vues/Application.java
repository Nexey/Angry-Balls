package vues;

import java.util.Vector;

import modele.Bille;
import �tats.Contr�leur�tat;

public abstract class Application {
	private Contr�leur�tat controleurCourant;
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
	
	public Contr�leur�tat getControleurCourant() {
		return controleurCourant;
	}
	
	public void setControleurCourant(Contr�leur�tat controleurCourant) {
		this.controleurCourant = controleurCourant;
	}
	
	public void arreter(){
        System.exit(0);
    }
}
