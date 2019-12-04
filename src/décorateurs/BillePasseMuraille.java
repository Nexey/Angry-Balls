package d�corateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BillePasseMuraille extends D�corateurBille {

	public BillePasseMuraille(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourPasseMuraille(this.getPosition(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
}
