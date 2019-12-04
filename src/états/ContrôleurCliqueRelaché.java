package états;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public class ContrôleurCliqueRelaché extends ContrôleurÉtat {

	public ContrôleurCliqueRelaché(Application application) {
		this(application, null, null);
	}

	public ContrôleurCliqueRelaché(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionDétectée(Vecteur pos) {
		if (this != application.getControleurCourant()) return;
		System.out.println("clic relaché en " + pos);
		traite(pos);
	}

	@Override
	public void traite(Vecteur pos) {
		this.étatSuivant();
	}

	@Override
	public void surChangementÉtat() {
		
	}
}
