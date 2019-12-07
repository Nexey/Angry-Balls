package �tats;

import main.AnimationBilles;
import main.ApplicationContr�l�e;
import modele.BoutonAvecIcones;

public class Contr�leurBoutonLancer extends Contr�leurBouton {

	public Contr�leurBoutonLancer(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContr�l�e application) {
		this(source, animationBilles, application, null, null);
	}

	public Contr�leurBoutonLancer(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(source, animationBilles, application, suivant, retour);
	}

	/**
	 * Lance l'animation et mets � jour l'icone de jeu
	 */
	@Override
	public void traite() {
		this.animationBilles.lancerAnimation();
		this.source.setIcon(this.source.getIcone("Arr�ter"));
	}
}
