package vues;

import java.util.Vector;

import modele.Bille;

public abstract class Application {
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
