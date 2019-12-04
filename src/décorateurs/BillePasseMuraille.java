package décorateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BillePasseMuraille extends DécorateurBille {

	public BillePasseMuraille(Bille billeDécorée) {
		super(billeDécorée);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourPasseMuraille(this.getPosition(), abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
}
