package �tats;

import main.ApplicationContr�l�e;


/**
 *
 * Le contr�leur d'�tat g�n�rique
 * Il contr�le une ApplicationContr�l�e (Ceci est mauvais, il devrait contr�ler une application g�n�rique)
 * Permet de v�rifier les diff�rents aspects du jeu
 * 
 */
public abstract class Contr�leur�tat {
	public ApplicationContr�l�e application;
	public Contr�leur�tat suivant, retour; // lien vers l'�tat suivant ou vers l'�tat pr�c�dent

	/**
	 * @param
	 * @param suivant
	 * @param retour
	 */
	public Contr�leur�tat(ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		this.application = application;
		this.suivant = suivant;
		this.retour = retour;
	}

	public Contr�leur�tat(ApplicationContr�l�e application) {
		this(application, null, null);
	}

	public void setSuivant(Contr�leur�tat suivant) {
		this.suivant = suivant;
	}

	public void setRetour(Contr�leur�tat retour) {
		this.retour = retour;
	}

	public abstract void actionD�tect�e(Object e);

	public void �tatSuivant() {
		if (suivant != null) {
		//	application.setControleurBoutonCourant(suivant);
			suivant.surChangement�tat();
		}
	}

	public void �tatRetour() {
		if (retour != null) {
		//	application.setControleurBoutonCourant(retour);
			retour.surChangement�tat();
		}
	}
	
	public abstract void traite();

	public abstract void surChangement�tat();
}