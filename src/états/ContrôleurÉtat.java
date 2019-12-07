package états;

import main.ApplicationContrôlée;


/**
 *
 * Le contrôleur d'état générique
 * Il contrôle une ApplicationContrôlée (Ceci est mauvais, il devrait contrôler une application générique)
 * Permet de vérifier les différents aspects du jeu
 * 
 */
public abstract class ContrôleurÉtat {
	public ApplicationContrôlée application;
	public ContrôleurÉtat suivant, retour; // lien vers l'état suivant ou vers l'état précédent

	/**
	 * @param
	 * @param suivant
	 * @param retour
	 */
	public ContrôleurÉtat(ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		this.application = application;
		this.suivant = suivant;
		this.retour = retour;
	}

	public ContrôleurÉtat(ApplicationContrôlée application) {
		this(application, null, null);
	}

	public void setSuivant(ContrôleurÉtat suivant) {
		this.suivant = suivant;
	}

	public void setRetour(ContrôleurÉtat retour) {
		this.retour = retour;
	}

	public abstract void actionDétectée(Object e);

	public void étatSuivant() {
		if (suivant != null) {
		//	application.setControleurBoutonCourant(suivant);
			suivant.surChangementÉtat();
		}
	}

	public void étatRetour() {
		if (retour != null) {
		//	application.setControleurBoutonCourant(retour);
			retour.surChangementÉtat();
		}
	}
	
	public abstract void traite();

	public abstract void surChangementÉtat();
}