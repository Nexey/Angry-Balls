package états;

import java.awt.Button;
import java.awt.event.ActionEvent;

import main.AnimationBilles;
import main.ApplicationContrôlée;
import vues.Application;

public abstract class ContrôleurBouton extends ContrôleurÉtat {
	protected AnimationBilles animationBilles;
	protected Button source; // Pour identifier quel bouton lève l'événement "ActionListener"

	public ContrôleurBouton(Button source, AnimationBilles animationBilles, ApplicationContrôlée application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBouton(Button source, AnimationBilles animationBilles, ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
		this.animationBilles = animationBilles;
		this.source = source;
	}

	@Override
	public void actionDétectée(Object e) {
		ActionEvent event = (ActionEvent) e;
		if (event.getSource() != this.source)
			return;
		traite();
		this.application.setContrôleurBoutonCourant(this.suivant);
	}
	
	@Override
	public void surChangementÉtat() {}

}
