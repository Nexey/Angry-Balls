package �tats;

import main.ApplicationContr�l�e;
import vues.Application;

public class Contr�leurCliqueRelach� extends Contr�leurClique {

	public Contr�leurCliqueRelach�(ApplicationContr�l�e application) {
		this(application, null, null);
	}

	public Contr�leurCliqueRelach�(ApplicationContr�l�e application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void traitementPosition() {
		
	}
}
