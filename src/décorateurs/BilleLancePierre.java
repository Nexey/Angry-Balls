package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BilleLancePierre extends BilleCliquable {
	protected boolean tenue;
	protected Vecteur vecteurDeb;

	public BilleLancePierre(Bille billeDécorée) {
		super(billeDécorée);
		this.tenue = false;
		this.vecteurDeb = Vecteur.VECTEURNUL;
	}

	protected void setVecteurDeb(Vecteur vecteurDeb) {
		this.vecteurDeb = vecteurDeb;
	}

	@Override
	public String toString() {
		return "bille lance-pière - " + this.billeDécorée.toString();
	}

	@Override
	public void gérerClique(InfoClique infoClique) {
		if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
			if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
				this.tenue = true;
				setVecteurDeb(infoClique.getPositionClique());
			}
		} else if (infoClique.getTypeDeClique() == InfoClique.RELACHÉ) {
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
	}
}