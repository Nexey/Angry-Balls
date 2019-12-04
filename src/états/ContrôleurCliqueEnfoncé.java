package états;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public class ContrôleurCliqueEnfoncé extends ContrôleurÉtat {

	public ContrôleurCliqueEnfoncé(Application application) {
		this(application, null, null);
	}

	public ContrôleurCliqueEnfoncé(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionDétectée(Vecteur pos) {
		if (this != application.getControleurCourant()) return;
		System.out.println("clic enfoncé en " + pos);
		traite();
	}

	@Override
	public void traite() {
		
		this.étatSuivant();
	}

	@Override
	public void surChangementÉtat() {
		
	}
}
