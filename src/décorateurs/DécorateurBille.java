package d�corateurs;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public class D�corateurBille extends Bille {

	protected D�corateurBille(Vecteur position, double rayon, Vecteur vitesse, Vecteur acc�l�ration, Color couleur) {
		super(position, rayon, vitesse, acc�l�ration, couleur);
	}
	

	public D�corateurBille(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}
	

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		super.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		
	}

}
