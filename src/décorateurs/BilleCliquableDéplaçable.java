package d�corateurs;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquableD�pla�able extends BilleCliquable {

	public BilleCliquableD�pla�able(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}


	/**
	 * @param direction     le vecteur de la nouvelle direction qui va influencer la bille
	 */
	public abstract Vecteur appliquerVecteurVitesse(Vecteur direction);

	/**
	 * @param infoClique     fais avancer la bille jusqu'� la derni�re position re�ue d'un �v�nement
	 */
	public void effectuerD�placementAuClique(InfoClique infoClique) {
		if (this.isCliqu�e()) {
			Vecteur direction = infoClique.getPositionClique().difference(this.posClique);

			this.getAcc�l�ration().ajoute(appliquerVecteurVitesse(direction));
			setPosClique(infoClique.getPositionClique());
		}
	}

}
