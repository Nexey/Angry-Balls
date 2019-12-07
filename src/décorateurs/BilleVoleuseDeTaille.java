package d�corateurs;

import java.util.Vector;

import modele.Bille;

public class BilleVoleuseDeTaille extends BilleVoleuse {
	protected double pourcentage;
	public BilleVoleuseDeTaille(Bille billeD�cor�e) {
		this(0.1, billeD�cor�e);
	}
	
	public BilleVoleuseDeTaille(double pourcentage, Bille billeD�cor�e) {
		super(billeD�cor�e);
		System.out.println(billeD�cor�e.masse());
		this.pourcentage = pourcentage;
	}


	/**
	 * @param billes		la liste de billes pour possiblement supprimer la bille vol�e si elle est trop petite
	 * @param billeVol�e	la bille qui va perdre un pourcentage de son rayon
	 * la taille consid�r�e trop petite ainsi que le pourcentage sont arbitraires
	 */
	@Override
	public boolean appliquerVol(Vector<Bille> billes, Bille billeVol�e) {
		double nouveauRayonBilleVol�e = billeVol�e.getRayon() * (1 - this.pourcentage);
		double rayonBilleAVoler = billeVol�e.getRayon() * this.pourcentage;
		if (nouveauRayonBilleVol�e < 4.)
			billes.remove(billeVol�e);
		else
			billeVol�e.setRayon(nouveauRayonBilleVol�e);
		this.setRayon(this.getRayon() + rayonBilleAVoler);
		return true;
	}
}
