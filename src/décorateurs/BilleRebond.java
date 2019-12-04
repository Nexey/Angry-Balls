package décorateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BilleRebond extends DécorateurBille {

	public BilleRebond(Bille billeDécorée) {
		super(billeDécorée);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	
	@Override
	public String toString() {
		return "bille rebondissante - " + this.billeDécorée.toString();
	}
}
