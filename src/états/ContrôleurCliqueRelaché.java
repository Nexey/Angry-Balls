package �tats;

import vues.Application;

public class Contr�leurCliqueRelach� extends Contr�leurClique {

	public Contr�leurCliqueRelach�(Application application) {
		this(application, null, null);
	}

	public Contr�leurCliqueRelach�(Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void traitementPosition() {
		
	}
}
