package d�corateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

/**
 * Cas d'une bille de billard qui peut �tre cliqu�e par l'utilisateur
 */

public abstract class BilleCliquable extends D�corateurBille implements Observer {
	protected Vecteur posClique;
	protected boolean cliqu�e;

	public BilleCliquable(Bille billeD�cor�e) {
		super(billeD�cor�e);
		this.cliqu�e = false;
		this.posClique = Vecteur.VECTEURNUL;
	}

	/**
	 * @param infoClique     g�re la position et la nature du dernier �v�nement re�u
	 * v�rifie que la pression du clique se soit effectu�e sur la bille
	 */
	public void g�rerPresse(InfoClique infoClique) {
		if (Geop.appartientDisque(infoClique.getPositionClique(), this.getPosition(), this.getRayon())) {
			this.cliqu�e = true;
			setPosClique(infoClique.getPositionClique());
		}
	}

	/**
	 * @param infoClique     g�re la position et la nature du dernier �v�nement re�u
	 * mets � jour la bille pendant le d�placement de la souris lors du maintien du clique
	 */
	public abstract void g�rerPresseMouvement(InfoClique infoClique);

	/**
	 * @param infoClique     g�re la position et la nature du dernier �v�nement re�u
	 * mets � jour la bille une fois le bouton relach�
	 */
	public void g�rerRelach�(InfoClique infoClique) {
		this.setCliqu�e(false);
		this.setPosClique(Vecteur.VECTEURNUL);
	}

	/**
	 * @param o     l'observable ayant lanc� l'appel
	 * @param arg	l'objet pass� en param�tre par l'observable
	 * transforme un arg en infoClique si possible et poursuit les traitements dessus
	 */
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
