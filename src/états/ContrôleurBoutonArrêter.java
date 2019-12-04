package états;

import java.awt.Button;

import main.AnimationBilles;
import main.ApplicationContrôlée;

public class ContrôleurBoutonArrêter extends ContrôleurBouton {

	public ContrôleurBoutonArrêter(Button source, AnimationBilles animationBilles, ApplicationContrôlée application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBoutonArrêter(Button source, AnimationBilles animationBilles, ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(source, animationBilles, application, suivant, retour);
	}
	
	@Override
	public void traite() {
		this.animationBilles.arrêterAnimation();
	}
}