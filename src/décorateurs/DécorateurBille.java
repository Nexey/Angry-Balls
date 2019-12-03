package d�corateurs;

import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public abstract class D�corateurBille extends Bille {
	
	protected Bille billeD�cor�e;

	protected D�corateurBille(Bille billeD�cor�e) {
		this.billeD�cor�e = billeD�cor�e;
	}
	
	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeD�cor�e.gestionAcc�l�ration(billes); // remise � z�ro du vecteur acc�l�ration
	}
	@Override
	public void dessine(Graphics g) {
		this.billeD�cor�e.dessine(g);
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
	public void d�placer(double deltaT) {
		this.billeD�cor�e.d�placer(deltaT);
	}

	@Override
	public double masse() {
		return this.billeD�cor�e.masse();
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return this.billeD�cor�e.gestionCollisionBilleBille(billes);
	}

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		this.billeD�cor�e.collisionContour(abscisseCoinHautGauche, ordonn�eCoinHautGauche, largeur, hauteur);
	}
	
}
