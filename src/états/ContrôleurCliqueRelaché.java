package �tats;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public class Contr�leurCliqueRelach� extends Contr�leur�tat {

	public Contr�leurCliqueRelach�(Application application) {
		this(application, null, null);
	}

	public Contr�leurCliqueRelach�(Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionD�tect�e(Vecteur pos) {
		if (this != application.getControleurCourant()) return;
		System.out.println("clic relach� en " + pos);
		traite();
	}

	@Override
	public void traite() {

		this.�tatSuivant();
	}

	@Override
	public void surChangement�tat() {
		
	}
}
