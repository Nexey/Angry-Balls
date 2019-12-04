package états;

import java.awt.Button;

import main.AnimationBilles;
import vues.Application;

public class ContrôleurBoutonArrêter extends ContrôleurBouton {

	public ContrôleurBoutonArrêter(Button source, AnimationBilles animationBilles, Application application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBoutonArrêter(Button source, AnimationBilles animationBilles, Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(source, animationBilles, application, suivant, retour);
	}
	
	@Override
	public void traite() {
		this.animationBilles.arrêterAnimation();
	}
}