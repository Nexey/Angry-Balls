package états;

import main.ApplicationContrôlée;
import vues.Application;

public class ContrôleurCliqueRelaché extends ContrôleurClique {

	public ContrôleurCliqueRelaché(ApplicationContrôlée application) {
		this(application, null, null);
	}

	public ContrôleurCliqueRelaché(ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void traitementPosition() {
		
	}
}
