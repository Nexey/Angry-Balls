package états;

import java.awt.Button;

import main.AnimationBilles;
import vues.Application;

public class ContrôleurBoutonLancer extends ContrôleurBouton {

	public ContrôleurBoutonLancer(Button source, AnimationBilles animationBilles, Application application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBoutonLancer(Button source, AnimationBilles animationBilles, Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(source, animationBilles, application, suivant, retour);
	}
	
	@Override
	public void traite() {
		this.animationBilles.lancerAnimation();
	}
}
