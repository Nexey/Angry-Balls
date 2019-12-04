package �tats;

import java.awt.event.KeyEvent;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public class Contr�leurBilleAttrap�e extends Contr�leur�tat {

	public Contr�leurBilleAttrap�e(Application application) {
		this(application, null, null);
	}

	public Contr�leurBilleAttrap�e(Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionD�tect�e(Vecteur pos) {
		if (this != application.getControleurCourant()) return;
		
		// Le clic gauche a �t� relach�
		this.�tatRetour();
	}

	@Override
	public void traite() {
		
	}

	@Override
	public void surChangement�tat() {
		
	}
}
