package �tats;

import main.ApplicationContr�l�e;
import modele.InfoClique;

/**
 * Le contr�leur par d�faut des cliques sur le billard
 * Le traitementPosition ne fait rien de plus que le clique par d�faut sauf pour l'action d�tect�e
 * 
 */
public class Contr�leurCliqueBillard extends Contr�leurClique {

	public Contr�leurCliqueBillard(ApplicationContr�l�e application) {
		this(application, null, null);
	}

	public Contr�leurCliqueBillard(ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	/**
	 * @param e      l'objet pass� lors de l'�v�nement
	 */
	@Override
	public void actionD�tect�e(Object e) {
		if (this != this.application.getContr�leurCliqueCourant())
			return;
		if (e instanceof InfoClique) {
			this.pos = ((InfoClique) e).getPositionClique();
			traite();
		}
	}

	@Override
	public void traitementPosition() {}
}
