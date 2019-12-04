package d�corateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BilleArr�t extends D�corateurBille {

	public BilleArr�t(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonn�eCoinHautGauche, hauteur);
	}
	
	@Override
	public String toString() {
		return "bille avec arr�t - " + this.billeD�cor�e.toString();
	}
}
