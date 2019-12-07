package �tats;

import java.awt.event.ActionEvent;

import main.AnimationBilles;
import main.ApplicationContr�l�e;
import modele.BoutonAvecIcones;

/**
 * 
 * Le contr�leur du bouton de jeu
 * L'application de base poss�dait 2 boutons qui pouvaient �tre r�sum�s en un seul bouton qui fait le travail
 * Ce contr�leur r�cup�re les �v�nements li�s aux boutons et mets � jour le jeu
 * 
 */
public abstract class Contr�leurBouton extends Contr�leur�tat {
	protected AnimationBilles animationBilles;
	protected BoutonAvecIcones source; // Pour identifier quel bouton l�ve l'�v�nement "ActionListener"

	public Contr�leurBouton(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContr�l�e application) {
		this(source, animationBilles, application, null, null);
	}

	public Contr�leurBouton(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
		this.animationBilles = animationBilles;
		this.source = source;
	}

	/**
	 * @param e     l'objet renvoy� par l'�v�nement
	 */
	@Override
	public void actionD�tect�e(Object e) {
		ActionEvent event = (ActionEvent) e;
		if (event.getSource() != this.source)
			return;
		traite();
		this.application.setContr�leurBoutonCourant(this.suivant);
	}
	
	@Override
	public void surChangement�tat() {}

}
