package décorateurs;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;

public class BilleFrottement extends DécorateurBille {

	public BilleFrottement(Bille billeDécorée) {
		super(billeDécorée);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));	// contribution
																											// de
																											// l'accélération
																											// due au
																											// frottement
																											// dans
																											// l'air// billes
	}
	
	@Override
	public String toString() {
		return "bille avec frottement - " + this.billeDécorée.toString();
	}
}
