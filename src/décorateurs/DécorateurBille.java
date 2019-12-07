package d�corateurs;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.OutilsBille;


/**
 * 
 * Le d�corateur de bille
 * G�re une bille (appel�e billeD�cor�e)
 * �tends Bille mais les m�thodes h�rit�es vont appeler les m�thodes de la bille d�cor�e
 * Permet de cr�er plein de comportements sans une explosion exponentielle du nombre de sous-classes de Bille
 * 
 */
public abstract class D�corateurBille extends Bille {
	
	protected Bille billeD�cor�e;

	public D�corateurBille(Bille billeD�cor�e) {
		super();
		this.billeD�cor�e = billeD�cor�e;
	}
	
	public int getClefD�corateur() {
		return this.clef;
	}
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeD�cor�e.gestionCollisionBilleBille(billes);
	}
	
	@Override
	public void setRayon(double rayon) {
		this.billeD�cor�e.setRayon(rayon);
	}
	
	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeD�cor�e.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
	}
	
	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		this.billeD�cor�e.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
	
	@Override
	public int getClef() {
		return this.billeD�cor�e.getClef();
	}
	
	@Override
	public Vecteur getAcc�l�ration() {
		return this.billeD�cor�e.getAcc�l�ration();
	}
	
	@Override
	public Vecteur getPosition() {
		return this.billeD�cor�e.getPosition();
	}
	
	@Override
	public double getRayon() {
		return this.billeD�cor�e.getRayon();
	}
	
	@Override
	public Vecteur getVitesse() {
		return this.billeD�cor�e.getVitesse();
		
	}
	
	@Override
	public double masse() {
		return this.billeD�cor�e.masse();
	}
	
	@Override
	public Color getCouleur() {
		return this.billeD�cor�e.getCouleur();
	}
	
	@Override
	public void setCouleur(Color couleur) {
		this.billeD�cor�e.setCouleur(couleur);
	}
	
}
