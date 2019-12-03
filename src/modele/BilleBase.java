package modele;

import java.awt.Color;

import mesmaths.geometrie.base.Vecteur;

public class BilleBase extends Bille {

	public BilleBase(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}

	protected BilleBase(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acc�l�ration, Color couleur) {
		super(centre, rayon, vitesse, acc�l�ration, couleur);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		// TODO Auto-generated method stub

	}

}
