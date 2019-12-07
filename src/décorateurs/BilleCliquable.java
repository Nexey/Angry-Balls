package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquable extends DécorateurBille implements Observer {
	protected Vecteur posClique;
	protected boolean cliquée;

	public BilleCliquable(Bille billeDécorée) {
		super(billeDécorée);
		this.cliquée = false;
		this.posClique = Vecteur.VECTEURNUL;
	}

	public void gérerPresse(InfoClique infoClique) {
		if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
			this.cliquée = true;
			setPosClique(infoClique.getPositionClique());
		}
	}

	public abstract void gérerPresseMouvement(InfoClique infoClique);

	public void gérerRelaché(InfoClique infoClique) {
		this.setCliquée(false);
		this.setPosClique(Vecteur.VECTEURNUL);
	}

	@Override
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
			if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
				gérerPresse(infoClique);
			}
			if (infoClique.getTypeDeClique() == InfoClique.PRESSÉ_BOUGEANT) {
				gérerPresseMouvement(infoClique);
			}
			if (infoClique.getTypeDeClique() == InfoClique.RELACHÉ) {
				gérerRelaché(infoClique);
			}
		}
	}

	protected Vecteur getPosClique() {
		return posClique;
	}

	protected void setPosClique(Vecteur posClique) {
		this.posClique = posClique;
	}

	protected boolean isCliquée() {
		return cliquée;
	}

	protected void setCliquée(boolean cliquée) {
		this.cliquée = cliquée;
	}

}
