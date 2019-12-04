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
	
	public Bille() {
		this.clef = Bille.prochaineClef++;
		
	}

	/**
	 * @return the clef
	 */
	public abstract int getClef();
	
	/**
	 * gestion de l'�ventuelle collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond
	 * sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs
	 *         vitesses des 2 billes impliqu�es dans le choc sont modifi�es si
	 *         renvoie false, il n'y a pas de collision et les billes sont laiss�es
	 *         intactes
	 */
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}
	
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

	/**
	 * mise � jour de position et vitesse � t+deltaT � partir de position et vitesse
	 * � l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur acc�l�ration intact
	 *
	 * La bille subit par d�faut un mouvement uniform�ment acc�l�r�
	 */
	public void d�placer(double deltaT) {
		Cinematique.mouvementUniform�mentAcc�l�r�(this.getPosition(), this.getVitesse(), this.getAcc�l�ration(), deltaT);
	}

	public abstract double masse();

	public abstract Color getCouleur();

	// TODO : Modifier �a par un visiteur
	public void dessine(Graphics g) {
		int width, height;
		int xMin, yMin;

		xMin = (int) Math.round(getPosition().x - getRayon());
		yMin = (int) Math.round(getPosition().y - getRayon());

		width = height = 2 * (int) Math.round(getRayon());

		g.setColor(getCouleur());
		g.fillOval(xMin, yMin, width, height);
		g.setColor(Color.CYAN);
		g.drawOval(xMin, yMin, width, height);
	}

//----------------- classe Bille -------------------------------------
}
