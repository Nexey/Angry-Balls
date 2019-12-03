package d�corateurs;

import java.util.Vector;

import modele.Bille;
import modele.OutilsBille;

public class BilleNewton extends D�corateurBille {
	
	protected BilleNewton(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}
	
	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
		this.billeD�cor�e.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this, billes)); // contribution de																				// billes
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		this.billeD�cor�e.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
}
