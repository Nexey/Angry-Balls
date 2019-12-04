package d�corateurs;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;
import modele.Bille;

public class BilleFrottement extends D�corateurBille {

	public BilleFrottement(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));	// contribution
																											// de
																											// l'acc�l�ration
																											// due au
																											// frottement
																											// dans
																											// l'air// billes
	}
	
	@Override
	public String toString() {
		return "bille avec frottement - " + this.billeD�cor�e.toString();
	}
}
