package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquable extends DécorateurBille implements Observer {

	public BilleCliquable(Bille billeDécorée) {
		super(billeDécorée);
	}
	
	public abstract void gérerClique(InfoClique infoClique);

	@Override
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
			gérerClique(infoClique);
			/*
			if (infoClique.isPressed()) {
				if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
					this.tenue = true;
					System.out.println("touché");
					setVecteurDeb(infoClique.getPositionClique());
				}
			} else if (infoClique.isReleased()) {
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

}
