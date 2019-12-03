package décorateurs;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public class DécorateurBille extends Bille {

	protected DécorateurBille(Vecteur position, double rayon, Vecteur vitesse, Vecteur accélération, Color couleur) {
		super(position, rayon, vitesse, accélération, couleur);
	}
	

	public DécorateurBille(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}
	

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		super.gestionAccélération(billes); // remise à zéro du vecteur accélération
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		
	}

}
