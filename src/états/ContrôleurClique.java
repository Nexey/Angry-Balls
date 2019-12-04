package �tats;

import java.awt.event.MouseEvent;

import main.ApplicationContr�l�e;
import mesmaths.geometrie.base.Vecteur;
import vues.Application;

public abstract class Contr�leurClique extends Contr�leur�tat {

	protected Vecteur pos;

	public Contr�leurClique(ApplicationContr�l�e application) {
		this(application, null, null);
	}

	public Contr�leurClique(ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionD�tect�e(Object e) {
		if (this != this.application.getContr�leurCliqueCourant())
			return;
		MouseEvent event = (MouseEvent) e;
		this.pos = new Vecteur(event.getX(), event.getY());
		traite();
	}

	@Override
	public void traite() {
		traitementPosition();
		this.application.setContr�leurCliqueCourant(this.suivant);
	}
	
	public abstract void traitementPosition();

	@Override
	public void surChangement�tat() {
		
	}

}
