package décorateurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

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
