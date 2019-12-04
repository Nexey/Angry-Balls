package états;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public abstract class ContrôleurClique extends ContrôleurÉtat {

	protected Vecteur pos;

	public ContrôleurClique(Application application) {
		this(application, null, null);
	}

	public ContrôleurClique(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionDétectée(Object e) {
		if (this != application.getControleurCourant())
			return;
		MouseEvent event = (MouseEvent) e;
		this.pos = new Vecteur(event.getX(), event.getY());
		traite();
	}

	@Override
	public void traite() {
		traitementPosition();
		this.étatSuivant();
	}
	
	public abstract void traitementPosition();

	@Override
	public void surChangementÉtat() {

	}

}
