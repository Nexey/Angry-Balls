package états;

import main.ApplicationContrôlée;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Application;

public class ContrôleurCliqueEnfoncé extends ContrôleurClique {

	public ContrôleurCliqueEnfoncé(ApplicationContrôlée application) {
		this(application, null, null);
	}

	public ContrôleurCliqueEnfoncé(ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}
	
	@Override
	public void traitementPosition() {}
}
