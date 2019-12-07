package visiteurs;

import modele.Bille;

/**
 * 
 * Un visiteur pour les billes
 * 
 */
public interface IVisiteur {

	/**
	 * @param bille
	 * Visite la bille et applique une action (utile pour le dessin)
	 */
	public boolean visite(Bille bille);
}
