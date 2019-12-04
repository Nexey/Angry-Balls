package décorateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public class BillePesanteur extends DécorateurBille {
	
	protected Vecteur pesanteur;

	public BillePesanteur(Vecteur pesanteur, Bille billeDécorée) {
		super(billeDécorée);
		this.pesanteur = pesanteur;
	}
	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}
	
	@Override
	public String toString() {
		return "bille avec pesanteur - " + this.billeDécorée.toString();
	}
}
