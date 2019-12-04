package décorateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BilleCollisionBille extends DécorateurBille {

	public BilleCollisionBille(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
}
