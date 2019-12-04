package décorateurs;

import mesmaths.cinematique.Collisions;
import modele.Bille;

public class BilleArrêt extends DécorateurBille {

	public BilleArrêt(Bille billeDécorée) {
		super(billeDécorée);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.getPosition(), this.getRayon(), this.getVitesse(), abscisseCoinHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.getPosition(), this.getRayon(), this.getVitesse(), ordonnéeCoinHautGauche, hauteur);
	}
	
	@Override
	public String toString() {
		return "bille avec arrêt - " + this.billeDécorée.toString();
	}
}
