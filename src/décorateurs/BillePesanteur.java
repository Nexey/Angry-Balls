package d�corateurs;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public class BillePesanteur extends D�corateurBille {
	
	protected Vecteur pesanteur;

	public BillePesanteur(Vecteur pesanteur, Bille billeD�cor�e) {
		super(billeD�cor�e);
		this.pesanteur = pesanteur;
	}
	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(this.pesanteur); // contribution du champ de pesanteur (par exemple)
	}
	
	@Override
	public String toString() {
		return "bille avec pesanteur - " + this.billeD�cor�e.toString();
	}
}
