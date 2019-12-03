package décorateurs;

import java.util.Vector;

import modele.Bille;
import modele.OutilsBille;

public class BilleNewton extends DécorateurBille {
	
	protected BilleNewton(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
		this.billeDécorée.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this, billes)); // contribution de																				// billes
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		this.billeDécorée.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
}
