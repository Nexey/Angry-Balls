package décorateurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.OutilsBille;


/**
 * 
 * Le décorateur de bille
 * Gère une bille (appelée billeDécorée)
 * Étends Bille mais les méthodes héritées vont appeler les méthodes de la bille décorée
 * Permet de créer plein de comportements sans une explosion exponentielle du nombre de sous-classes de Bille
 * 
 */
public abstract class DécorateurBille extends Bille {
	
	protected Bille billeDécorée;

	public DécorateurBille(Bille billeDécorée) {
		super();
		this.billeDécorée = billeDécorée;
	}
	
	public int getClefDécorateur() {
		return this.clef;
	}
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeDécorée.gestionCollisionBilleBille(billes);
	}
	
	@Override
	public void setRayon(double rayon) {
		this.billeDécorée.setRayon(rayon);
	}
	
	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDécorée.gestionAccélération(billes); // remise à zéro du vecteur accélération
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		this.billeDécorée.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	
	@Override
	public int getClef() {
		return this.billeDécorée.getClef();
	}
	
	@Override
	public Vecteur getAccélération() {
		return this.billeDécorée.getAccélération();
	}
	
	@Override
	public Vecteur getPosition() {
		return this.billeDécorée.getPosition();
	}
	
	@Override
	public double getRayon() {
		return this.billeDécorée.getRayon();
	}
	
	@Override
	public Vecteur getVitesse() {
		return this.billeDécorée.getVitesse();
		
	}
	
	@Override
	public double masse() {
		return this.billeDécorée.masse();
	}
	
	@Override
	public Color getCouleur() {
		return this.billeDécorée.getCouleur();
	}
	
	@Override
	public void setCouleur(Color couleur) {
		this.billeDécorée.setCouleur(couleur);
	}
	
}
