package �tats;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public abstract class Contr�leur�tat {
	Application application;
	public Contr�leur�tat suivant, retour; // lien vers l'�tat suivant ou vers l'�tat pr�c�dent

	/**
	 * @param
	 * @param suivant
	 * @param retour
	 */
	public Contr�leur�tat(Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		this.application = application;
		this.suivant = suivant;
		this.retour = retour;
	}

	public Contr�leur�tat(Application application) {
		this(application, null, null);
	}

	public void setSuivant(Contr�leur�tat suivant) {
		this.suivant = suivant;
	}

	public void setRetour(Contr�leur�tat retour) {
		this.retour = retour;
	}

	public abstract void actionD�tect�e(Vecteur pos);

	public void �tatSuivant() {
		if (suivant != null) {
			application.setControleurCourant(suivant);
			suivant.surChangement�tat();
		}
	}

	public void �tatRetour() {
		if (retour != null) {
			application.setControleurCourant(retour);
			retour.surChangement�tat();
		}
	}
	
	public abstract void traite();

	public abstract void surChangement�tat();
}