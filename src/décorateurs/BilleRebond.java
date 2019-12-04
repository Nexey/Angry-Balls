package d�corateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BilleRebond extends D�corateurBille {

	public BilleRebond(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
}
