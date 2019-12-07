package d�corateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public abstract class BilleCliquable extends D�corateurBille implements Observer {
	protected Vecteur posClique;
	protected boolean cliqu�e;

	public BilleCliquable(Bille billeD�cor�e) {
		super(billeD�cor�e);
		this.cliqu�e = false;
		this.posClique = Vecteur.VECTEURNUL;
	}

	public void g�rerPresse(InfoClique infoClique) {
		if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
			this.cliqu�e = true;
			setPosClique(infoClique.getPositionClique());
		}
	}

	public abstract void g�rerPresseMouvement(InfoClique infoClique);

	public void g�rerRelach�(InfoClique infoClique) {
		this.setCliqu�e(false);
		this.setPosClique(Vecteur.VECTEURNUL);
	}

	@Override
	public void update(Observable o, Object arg) {
		InfoClique infoClique;
		if (arg instanceof InfoClique) {
			infoClique = (InfoClique) arg;
			if (infoClique.getTypeDeClique() == InfoClique.PRESSE_INITIALE) {
				g�rerPresse(infoClique);
			}
			if (infoClique.getTypeDeClique() == InfoClique.PRESS�_BOUGEANT) {
				g�rerPresseMouvement(infoClique);
			}
			if (infoClique.getTypeDeClique() == InfoClique.RELACH�) {
				g�rerRelach�(infoClique);
			}
		}
	}

	protected Vecteur getPosClique() {
		return posClique;
	}

	protected void setPosClique(Vecteur posClique) {
		this.posClique = posClique;
	}

	protected boolean isCliqu�e() {
		return cliqu�e;
	}

	protected void setCliqu�e(boolean cliqu�e) {
		this.cliqu�e = cliqu�e;
	}

}
