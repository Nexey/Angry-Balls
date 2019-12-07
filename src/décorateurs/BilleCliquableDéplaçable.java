package d�corateurs;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquableD�pla�able extends BilleCliquable {

	public BilleCliquableD�pla�able(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}
	
	public void effectuerD�placementAuClique(InfoClique infoClique) {
		if (this.isCliqu�e()) {
			Vecteur direction = infoClique.getPositionClique().difference(this.posClique);
			
			Vecteur nouvelleVitesse = new Vecteur(0, 0);
			nouvelleVitesse.x = direction.x / 10000;
			nouvelleVitesse.y = direction.y / 10000;

			this.getAcc�l�ration().ajoute(nouvelleVitesse);
			setPosClique(infoClique.getPositionClique());
		}
	}

}
