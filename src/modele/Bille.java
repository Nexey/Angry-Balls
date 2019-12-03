package modele;

import java.awt.*;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Cas g�n�ral d'une bille de billard
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
	 * gestion de l'�ventuelle collision de la bille (this) avec le contour
	 * rectangulaire de l'�cran d�fini par (abscisseCoinHautGauche,
	 * ordonn�eCoinHautGauche, largeur, hauteur)
	 * 
	 * d�tecte si il y a collision et le cas �ch�ant met � jour position et vitesse
	 * 
	 * La nature du comportement de la bille en r�ponse � cette collision est
	 * d�finie dans les classes d�riv�es
	 */
	public abstract void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur);

	public abstract Vecteur getAcc�l�ration();

	public abstract Vecteur getPosition();

	public abstract double getRayon();

	public abstract Vecteur getVitesse();

	public abstract void gestionAcc�l�ration(Vector<Bille> billes);

	public abstract void d�placer(double deltaT);

	public abstract boolean gestionCollisionBilleBille(Vector<Bille> billes);

	public abstract double masse();

//----------------- classe Bille -------------------------------------
}
