package décorateurs;

import java.util.Vector;

import modele.Bille;

public class BilleVoleuseDeTaille extends BilleVoleuse {
	protected double pourcentage;
	public BilleVoleuseDeTaille(Bille billeDécorée) {
		this(0.1, billeDécorée);
	}
	
	public BilleVoleuseDeTaille(double pourcentage, Bille billeDécorée) {
		super(billeDécorée);
		System.out.println(billeDécorée.masse());
		this.pourcentage = pourcentage;
	}


	/**
	 * @param billes		la liste de billes pour possiblement supprimer la bille volée si elle est trop petite
	 * @param billeVolée	la bille qui va perdre un pourcentage de son rayon
	 * la taille considérée trop petite ainsi que le pourcentage sont arbitraires
	 */
	@Override
	public boolean appliquerVol(Vector<Bille> billes, Bille billeVolée) {
		double nouveauRayonBilleVolée = billeVolée.getRayon() * (1 - this.pourcentage);
		double rayonBilleAVoler = billeVolée.getRayon() * this.pourcentage;
		if (nouveauRayonBilleVolée < 4.)
			billes.remove(billeVolée);
		else
			billeVolée.setRayon(nouveauRayonBilleVolée);
		this.setRayon(this.getRayon() + rayonBilleAVoler);
		return true;
	}
}
