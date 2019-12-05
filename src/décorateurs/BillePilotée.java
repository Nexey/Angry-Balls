package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BillePilotée extends DécorateurBille implements Observer {
	protected boolean pilotée;
	protected Vecteur vecteurDeb;

	public BillePilotée(Bille billeDécorée) {
		super(billeDécorée);
		this.pilotée = false;
		this.vecteurDeb = Vecteur.VECTEURNUL;
	}

	protected void setVecteurDeb(Vecteur vecteurDeb) {
		this.vecteurDeb = vecteurDeb;
	}

	@Override
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
			if (infoClique.isPressed()) {
				if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
					this.pilotée = true;
					System.out.println("touché");
					setVecteurDeb(infoClique.getPositionClique());
				}
			} else if (infoClique.isReleased()) {
				if (this.pilotée) {
					this.pilotée = false;
					Vecteur direction = infoClique.getPositionClique().difference(this.vecteurDeb);
					// direction = this.vecteurDeb.difference(infoClique.getPositionClique());
					Vecteur nouvelleVitesse = this.getVitesse().somme(direction);
					nouvelleVitesse.x /= 1000;
					nouvelleVitesse.y /= 1000;
					this.getVitesse().set(nouvelleVitesse);
					System.out.println("relaché");
					System.out.println(this.vecteurDeb + " -> " + infoClique.getPositionClique());
					System.out.println(direction);
					setVecteurDeb(Vecteur.VECTEURNUL);
				}
			}
		}
	}
}