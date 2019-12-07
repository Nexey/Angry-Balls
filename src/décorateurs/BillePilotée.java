package d�corateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BillePilot�e extends BilleCliquable {
	protected Vecteur posCliquePr�c�dent;

	public BillePilot�e(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}
	
	@Override
	public void g�rerClique(InfoClique infoClique) {
		System.out.println(infoClique);
		if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
			posCliquePr�c�dent = infoClique.getPositionClique();
		}
		if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
			
		}
		if (infoClique.getTypeDeClique() == InfoClique.RELACH�) {
			
		}
		/*
		if (infoClique.getTypeDeClique().equals("press�")) {
			if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
				this.tenue = true;
				setVecteurDeb(infoClique.getPositionClique());
			}
		} else if (infoClique.getTypeDeClique().equals("relach�")) {
			if (this.tenue) {
				this.tenue = false;
				Vecteur direction = infoClique.getPositionClique().difference(this.vecteurDeb);

				Vecteur nouvelleVitesse = new Vecteur(0, 0);
				nouvelleVitesse.x = direction.x / 10000;
				nouvelleVitesse.y = direction.y / 10000;

				this.getAcc�l�ration().ajoute(nouvelleVitesse);
				setVecteurDeb(Vecteur.VECTEURNUL);
			}
		}
		*/
	}
}
