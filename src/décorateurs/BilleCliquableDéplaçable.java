package décorateurs;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquableDéplaçable extends BilleCliquable {

	public BilleCliquableDéplaçable(Bille billeDécorée) {
		super(billeDécorée);
	}


	/**
	 * @param direction     le vecteur de la nouvelle direction qui va influencer la bille
	 */
	public abstract Vecteur appliquerVecteurVitesse(Vecteur direction);

	/**
	 * @param infoClique     fais avancer la bille jusqu'à la dernière position reçue d'un événement
	 */
	public void effectuerDéplacementAuClique(InfoClique infoClique) {
		if (this.isCliquée()) {
			Vecteur direction = infoClique.getPositionClique().difference(this.posClique);

			this.getAccélération().ajoute(appliquerVecteurVitesse(direction));
			setPosClique(infoClique.getPositionClique());
		}
	}

}
