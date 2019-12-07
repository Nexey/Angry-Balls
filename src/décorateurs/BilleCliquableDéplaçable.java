package décorateurs;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquableDéplaçable extends BilleCliquable {

	public BilleCliquableDéplaçable(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	public abstract Vecteur appliquerVecteurVitesse(Vecteur direction);
	
	public void effectuerDéplacementAuClique(InfoClique infoClique) {
		if (this.isCliquée()) {
			Vecteur direction = infoClique.getPositionClique().difference(this.posClique);

			this.getAccélération().ajoute(appliquerVecteurVitesse(direction));
			setPosClique(infoClique.getPositionClique());
		}
	}

}
