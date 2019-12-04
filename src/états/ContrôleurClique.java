package états;

import java.awt.event.MouseEvent;

import main.ApplicationContrôlée;
import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public abstract class ContrôleurClique extends ContrôleurÉtat {

	protected Vecteur pos;

	public ContrôleurClique(ApplicationContrôlée application) {
		this(application, null, null);
	}

	public ContrôleurClique(ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionDétectée(Object e) {
		if (this != this.application.getContrôleurCliqueCourant())
			return;
		MouseEvent event = (MouseEvent) e;
		this.pos = new Vecteur(event.getX(), event.getY());
		traite();
	}

	@Override
	public void traite() {
		traitementPosition();
		this.application.setContrôleurCliqueCourant(this.suivant);
	}
	
	public abstract void traitementPosition();

	@Override
	public void surChangementÉtat() {
		
	}

}
