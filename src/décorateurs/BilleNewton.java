package décorateurs;

import java.util.Vector;
import modele.Bille;
import modele.OutilsBille;

public class BilleNewton extends DécorateurBille {
	
	public BilleNewton(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes)); // contribution de
																							// l'accélération due à
																							// l'attraction des autres
																							// billes
	}
}
