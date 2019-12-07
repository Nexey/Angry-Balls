package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

/**
 * Cas d'une bille de billard qui peut être cliquée par l'utilisateur
 */

public abstract class BilleCliquable extends DécorateurBille implements Observer {
	protected Vecteur posClique;
	protected boolean cliquée;

	public BilleCliquable(Bille billeDécorée) {
		super(billeDécorée);
		this.cliquée = false;
		this.posClique = Vecteur.VECTEURNUL;
	}

	/**
	 * @param infoClique     gère la position et la nature du dernier événement reçu
	 * vérifie que la pression du clique se soit effectuée sur la bille
	 */
	public void gérerPresse(InfoClique infoClique) {
		if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
			this.cliquée = true;
			setPosClique(infoClique.getPositionClique());
		}
	}

	/**
	 * @param infoClique     gère la position et la nature du dernier événement reçu
	 * mets à jour la bille pendant le déplacement de la souris lors du maintien du clique
	 */
	public abstract void gérerPresseMouvement(InfoClique infoClique);

	/**
	 * @param infoClique     gère la position et la nature du dernier événement reçu
	 * mets à jour la bille une fois le bouton relaché
	 */
	public void gérerRelaché(InfoClique infoClique) {
		this.setCliquée(false);
		this.setPosClique(Vecteur.VECTEURNUL);
	}

	/**
	 * @param o     l'observable ayant lancé l'appel
	 * @param arg	l'objet passé en paramètre par l'observable
	 * transforme un arg en infoClique si possible et poursuit les traitements dessus
	 */
	@Override
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
			if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
				gérerPresse(infoClique);
			}
			if (infoClique.getTypeDeClique() == InfoClique.PRESSÉ_BOUGEANT) {
				gérerPresseMouvement(infoClique);
			}
			if (infoClique.getTypeDeClique() == InfoClique.RELACHÉ) {
				gérerRelaché(infoClique);
			}
		}
	}

	protected Vecteur getPosClique() {
		return posClique;
	}

	protected void setPosClique(Vecteur posClique) {
		this.posClique = posClique;
	}

	protected boolean isCliquée() {
		return cliquée;
	}

	protected void setCliquée(boolean cliquée) {
		this.cliquée = cliquée;
	}

}
