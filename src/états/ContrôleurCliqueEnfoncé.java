package �tats;

import main.ApplicationContr�l�e;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Application;

public class Contr�leurCliqueEnfonc� extends Contr�leurClique {

	public Contr�leurCliqueEnfonc�(ApplicationContr�l�e application) {
		this(application, null, null);
	}

	public Contr�leurCliqueEnfonc�(ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}
	
	@Override
	public void traitementPosition() {}
}
