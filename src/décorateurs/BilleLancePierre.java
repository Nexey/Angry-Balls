package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BilleLancePierre extends DécorateurBille implements Observer {
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
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
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
					// direction = this.vecteurDeb.difference(infoClique.getPositionClique());
					
					Vecteur nouvelleVitesse = new Vecteur(0, 0);
					//nouvelleVitesse = new Vecteur(this.getVitesse().x + this.getPosition().x, this.getVitesse().y + this.getPosition().y).somme(direction);
					nouvelleVitesse.x = direction.x / 10000;
					nouvelleVitesse.y = direction.y / 10000;
					
					this.getAccélération().ajoute(nouvelleVitesse);
					// System.out.println("relaché");
					// System.out.println(this.vecteurDeb + " -> " + infoClique.getPositionClique());
					// System.out.println(direction);
					setVecteurDeb(Vecteur.VECTEURNUL);
				}
			}
		}
	}

	@Override
	public String toString() {
		return "bille lance-pière - " + this.billeDécorée.toString();
	}
}