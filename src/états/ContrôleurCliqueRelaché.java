package états;

import vues.Application;

public class ContrôleurCliqueRelaché extends ContrôleurClique {

	public ContrôleurCliqueRelaché(Application application) {
		this(application, null, null);
	}

	public ContrôleurCliqueRelaché(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void traitementPosition() {
		
	}
}
