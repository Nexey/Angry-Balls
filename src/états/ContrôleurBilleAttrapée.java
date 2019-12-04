package états;

import java.awt.event.KeyEvent;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public class ContrôleurBilleAttrapée extends ContrôleurÉtat {

	public ContrôleurBilleAttrapée(Application application) {
		this(application, null, null);
	}

	public ContrôleurBilleAttrapée(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionDétectée(Vecteur pos) {
		if (this != application.getControleurCourant()) return;
		
		// Le clic gauche a été relaché
		this.étatRetour();
	}

	@Override
	public void traite() {
		
	}

	@Override
	public void surChangementÉtat() {
		
	}
}
