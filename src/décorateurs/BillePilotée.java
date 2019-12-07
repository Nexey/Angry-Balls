package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BillePilotée extends BilleCliquable {
	protected Vecteur posCliquePrécédent;

	public BillePilotée(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	@Override
	public void gérerClique(InfoClique infoClique) {
		System.out.println(infoClique);
		if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
			posCliquePrécédent = infoClique.getPositionClique();
		}
		if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
			
		}
		if (infoClique.getTypeDeClique() == InfoClique.RELACHÉ) {
			
		}
		/*
		if (infoClique.getTypeDeClique().equals("pressé")) {
			if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
				this.tenue = true;
				setVecteurDeb(infoClique.getPositionClique());
			}
		} else if (infoClique.getTypeDeClique().equals("relaché")) {
			if (this.tenue) {
				this.tenue = false;
				Vecteur direction = infoClique.getPositionClique().difference(this.vecteurDeb);

				Vecteur nouvelleVitesse = new Vecteur(0, 0);
				nouvelleVitesse.x = direction.x / 10000;
				nouvelleVitesse.y = direction.y / 10000;

				this.getAccélération().ajoute(nouvelleVitesse);
				setVecteurDeb(Vecteur.VECTEURNUL);
			}
		}
		*/
	}
}
