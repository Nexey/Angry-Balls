package états;

import java.awt.event.ActionEvent;

import main.AnimationBilles;
import main.ApplicationContrôlée;
import modele.BoutonAvecIcones;

public abstract class ContrôleurBouton extends ContrôleurÉtat {
	protected AnimationBilles animationBilles;
	protected BoutonAvecIcones source; // Pour identifier quel bouton lève l'événement "ActionListener"

	public ContrôleurBouton(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContrôlée application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBouton(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
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
