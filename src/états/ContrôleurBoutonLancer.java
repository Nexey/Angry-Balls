package �tats;

import java.awt.Button;

import main.AnimationBilles;
import vues.Application;

public class Contr�leurBoutonLancer extends Contr�leurBouton {

	public Contr�leurBoutonLancer(Button source, AnimationBilles animationBilles, Application application) {
		this(source, animationBilles, application, null, null);
	}

	public Contr�leurBoutonLancer(Button source, AnimationBilles animationBilles, Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(source, animationBilles, application, suivant, retour);
	}
	
	@Override
	public void traite() {
		this.animationBilles.lancerAnimation();
	}
}
