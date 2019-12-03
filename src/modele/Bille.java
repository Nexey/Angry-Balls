package modele;

import java.awt.*;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Cas général d'une bille de billard
 * 
 * A MODIFIER
 * 
 * 
 */
public abstract class Bille {
//----------------- classe Bille-------------------------------------

	public int clef; // identifiant unique de cette bille
	protected static int prochaineClef = 0;
	
	/**
	 * @return the clef
	 */
	public int getClef() {
		return this.clef;
	}
	
	public abstract void dessine(Graphics g);
	/**
	 * gestion de l'éventuelle collision de la bille (this) avec le contour
	 * rectangulaire de l'écran défini par (abscisseCoinHautGauche,
	 * ordonnéeCoinHautGauche, largeur, hauteur)
	 * 
	 * détecte si il y a collision et le cas échéant met à jour position et vitesse
	 * 
	 * La nature du comportement de la bille en réponse à cette collision est
	 * définie dans les classes dérivées
	 */
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur);

	public abstract Vecteur getAccélération();

	public abstract Vecteur getPosition();

	public abstract double getRayon();

	public abstract Vecteur getVitesse();

	public abstract void gestionAccélération(Vector<Bille> billes);

	public abstract void déplacer(double deltaT);

	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	public abstract double masse();

//----------------- classe Bille -------------------------------------
}
