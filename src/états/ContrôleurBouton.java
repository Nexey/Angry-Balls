package �tats;

import java.awt.event.ActionEvent;

import main.AnimationBilles;
import main.ApplicationContr�l�e;
import modele.BoutonAvecIcones;

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
