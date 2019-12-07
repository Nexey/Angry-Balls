package �tats;

import main.ApplicationContr�l�e;
import mesmaths.geometrie.base.Vecteur;
import modele.InfoClique;


/**
 * 
 * Le contr�leur qui g�re les �v�nements li�s aux cliques
 */
public abstract class Contr�leurClique extends Contr�leur�tat {

	protected Vecteur pos;

	public Contr�leurClique(ApplicationContr�l�e application) {
		this(application, null, null);
	}

	public Contr�leurClique(ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
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
