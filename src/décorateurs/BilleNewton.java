package d�corateurs;

import java.util.Vector;
import modele.Bille;
import modele.OutilsBille;

public class BilleNewton extends D�corateurBille {
	
	public BilleNewton(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}
	
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes)); // contribution de
																							// l'acc�l�ration due �
																							// l'attraction des autres
																							// billes
	}
}
