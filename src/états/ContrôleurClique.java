package �tats;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public abstract class Contr�leurClique extends Contr�leur�tat {

	protected Vecteur pos;

	public Contr�leurClique(Application application) {
		this(application, null, null);
	}

	public Contr�leurClique(Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionD�tect�e(Object e) {
		if (this != application.getControleurCourant())
			return;
		MouseEvent event = (MouseEvent) e;
		this.pos = new Vecteur(event.getX(), event.getY());
		traite();
	}

	@Override
	public void traite() {
		traitementPosition();
		this.�tatSuivant();
	}
	
	public abstract void traitementPosition();

	@Override
	public void surChangement�tat() {

	}

}
