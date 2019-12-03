package décorateurs;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public abstract class DécorateurBille extends Bille {
	
	protected Bille billeDécorée;

	protected DécorateurBille(Bille billeDécorée) {
		this.billeDécorée = billeDécorée;
	}
	
	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDécorée.gestionAccélération(billes); // remise à zéro du vecteur accélération
	}
	@Override
	public void dessine(Graphics g) {
		this.billeDécorée.dessine(g);
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
	public void déplacer(double deltaT) {
		this.billeDécorée.déplacer(deltaT);
	}

	@Override
	public double masse() {
		return this.billeDécorée.masse();
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeDécorée.gestionCollisionBilleBille(billes);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		this.billeDécorée.collisionContour(abscisseCoinHautGauche, ordonnéeCoinHautGauche, largeur, hauteur);
	}
	
}
