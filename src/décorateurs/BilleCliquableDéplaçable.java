package décorateurs;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquableDéplaçable extends BilleCliquable {

	public BilleCliquableDéplaçable(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	public void effectuerDéplacementAuClique(InfoClique infoClique) {
		if (this.isCliquée()) {
			Vecteur direction = infoClique.getPositionClique().difference(this.posClique);
			
			Vecteur nouvelleVitesse = new Vecteur(0, 0);
			nouvelleVitesse.x = direction.x / 10000;
			nouvelleVitesse.y = direction.y / 10000;

			this.getAccélération().ajoute(nouvelleVitesse);
			setPosClique(infoClique.getPositionClique());
		}
	}

}
