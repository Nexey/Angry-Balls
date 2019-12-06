package modele;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

public class BilleParD�faut extends Bille {
	public Vecteur position; // centre de la bille
	public double rayon; // rayon > 0
	public Vecteur vitesse;
	public Vecteur acc�l�ration;
	public static double ro = 1; // masse volumique
	private Color couleur;

	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acc�l�ration
	 * @param couleur
	 */
	public BilleParD�faut(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acc�l�ration, Color couleur) {
		super();
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acc�l�ration = acc�l�ration;
		this.couleur = couleur;
	}

	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleParD�faut(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		this(position, rayon, vitesse, new Vecteur(), couleur);
	}

	/**
	 * @param position
	 * @param rayon
	 * @param couleur
	 */
	public BilleParD�faut(Vecteur position, double rayon, Color couleur) {
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
	 * @return the acc�l�ration
	 */
	public Vecteur getAcc�l�ration() {
		return this.acc�l�ration;
	}

	public double masse() {
		return ro * Geop.volumeSph�re(rayon);
	}

	/**
	 * calcul (c-�-d mise � jour) �ventuel du vecteur acc�l�ration. billes est la
	 * liste de toutes les billes en mouvement Cette m�thode peut avoir besoin de
	 * "billes" si this subit l'attraction gravitationnelle des autres billes La
	 * nature du calcul du vecteur acc�l�ration de la bille est d�finie dans les
	 * classes d�riv�es A ce niveau le vecteur acc�l�ration est mis � z�ro (c'est �
	 * dire pas d'acc�l�ration)
	 */
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.getAcc�l�ration().set(Vecteur.VECTEURNUL);
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
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {}
}
