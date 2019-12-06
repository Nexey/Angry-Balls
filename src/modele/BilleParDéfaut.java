package modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleParDéfaut extends Bille {
	public Vecteur position; // centre de la bille
	public double rayon; // rayon > 0
	public Vecteur vitesse;
	public Vecteur accélération;
	public static double ro = 1; // masse volumique
	private Color couleur;

	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param accélération
	 * @param couleur
	 */
	public BilleParDéfaut(Vecteur centre, double rayon, Vecteur vitesse, Vecteur accélération, Color couleur) {
		super();
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.accélération = accélération;
		this.couleur = couleur;
	}

	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleParDéfaut(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}

	/**
	 * @param position
	 * @param rayon
	 * @param couleur
	 */
	public BilleParDéfaut(Vecteur position, double rayon, Color couleur) {
		this(position, rayon, new Vecteur(), new Vecteur(), couleur);
	}
	
	/**
	 * @return the position
	 */
	public Vecteur getPosition() {
		return this.position;
	}

	/**
	 * @return the rayon
	 */
	public double getRayon() {
		return this.rayon;
	}
	
	@Override
	public void setRayon(double rayon) {
		this.rayon = rayon;
	}

	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse() {
		return this.vitesse;
	}

	/**
	 * @return the accélération
	 */
	public Vecteur getAccélération() {
		return this.accélération;
	}

	public double masse() {
		return ro * Geop.volumeSphère(rayon);
	}

	/**
	 * calcul (c-à-d mise à jour) éventuel du vecteur accélération. billes est la
	 * liste de toutes les billes en mouvement Cette méthode peut avoir besoin de
	 * "billes" si this subit l'attraction gravitationnelle des autres billes La
	 * nature du calcul du vecteur accélération de la bille est définie dans les
	 * classes dérivées A ce niveau le vecteur accélération est mis à zéro (c'est à
	 * dire pas d'accélération)
	 */
	public void gestionAccélération(Vector<Bille> billes) {
		this.getAccélération().set(Vecteur.VECTEURNUL);
	}
	
	@Override
	public Color getCouleur() {
		return couleur;
	}
	@Override
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	@Override
	public int getClef() {
		return this.clef;
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {}
}
