package d�corateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquable extends D�corateurBille implements Observer {

	public BilleCliquable(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}
	
	public abstract void g�rerClique(InfoClique infoClique);

	@Override
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
			g�rerClique(infoClique);
			/*
			if (infoClique.isPressed()) {
				if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
					this.tenue = true;
					System.out.println("touch�");
					setVecteurDeb(infoClique.getPositionClique());
				}
			} else if (infoClique.isReleased()) {
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

}
