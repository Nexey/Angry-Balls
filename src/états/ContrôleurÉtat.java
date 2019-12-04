package états;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public abstract class ContrôleurÉtat {
	Application application;
	public ContrôleurÉtat suivant, retour; // lien vers l'état suivant ou vers l'état précédent

	/**
	 * @param
	 * @param suivant
	 * @param retour
	 */
	public ContrôleurÉtat(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		this.application = application;
		this.suivant = suivant;
		this.retour = retour;
	}

	public ContrôleurÉtat(Application application) {
		this(application, null, null);
	}

	public void setSuivant(ContrôleurÉtat suivant) {
		this.suivant = suivant;
	}

	public void setRetour(ContrôleurÉtat retour) {
		this.retour = retour;
	}

	public abstract void actionDétectée(Vecteur pos);

	public void étatSuivant() {
		if (suivant != null) {
			application.setControleurCourant(suivant);
			suivant.surChangementÉtat();
		}
	}

	public void étatRetour() {
		if (retour != null) {
			application.setControleurCourant(retour);
			retour.surChangementÉtat();
		}
	}
	
	public abstract void traite();

	public abstract void surChangementÉtat();
}