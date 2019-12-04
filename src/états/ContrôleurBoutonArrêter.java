package �tats;

import java.awt.Button;

import main.AnimationBilles;
import vues.Application;

public class Contr�leurBoutonArr�ter extends Contr�leurBouton {

	public Contr�leurBoutonArr�ter(Button source, AnimationBilles animationBilles, Application application) {
		this(source, animationBilles, application, null, null);
	}

	public Contr�leurBoutonArr�ter(Button source, AnimationBilles animationBilles, Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(source, animationBilles, application, suivant, retour);
	}
	
	@Override
	public void traite() {
		this.animationBilles.arr�terAnimation();
	}
}