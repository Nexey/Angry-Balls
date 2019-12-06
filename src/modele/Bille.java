package modele;

import java.awt.*;
import java.util.Vector;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Vecteur;
import visiteurs.IVisiteur;

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
	
	public Bille() {
		this.clef = Bille.prochaineClef++;
	}

	/**
	 * @return the clef
	 */
	public abstract int getClef();
	
	
	public boolean accepte(IVisiteur visiteur) {
		return visiteur.visite(this);
	}
	
	public abstract void setRayon(double rayon);
	
	/**
	 * gestion de l'éventuelle collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond
	 * sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs
	 *         vitesses des 2 billes impliquées dans le choc sont modifiées si
	 *         renvoie false, il n'y a pas de collision et les billes sont laissées
	 *         intactes
	 */
	
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

	/**
	 * mise à jour de position et vitesse à t+deltaT à partir de position et vitesse
	 * à l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur accélération intact
	 *
	 * La bille subit par défaut un mouvement uniformément accéléré
	 */
	public void déplacer(double deltaT) {
		Cinematique.mouvementUniformémentAccéléré(this.getPosition(), this.getVitesse(), this.getAccélération(), deltaT);
	}
	
	public abstract void setCouleur(Color couleur);
	
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

	public abstract double masse();

	public abstract Color getCouleur();
	
	public String toString() {
		return "centre = " + getPosition() + " rayon = " + getRayon() + " vitesse = " + getVitesse() + " accélération = " + getAccélération() + " couleur = " + getCouleur() + "clef = " + getClef();
	}

//----------------- classe Bille -------------------------------------
}
