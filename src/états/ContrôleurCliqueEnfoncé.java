package états;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Application;

public class ContrôleurCliqueEnfoncé extends ContrôleurClique {

	public ContrôleurCliqueEnfoncé(Application application) {
		this(application, null, null);
	}

	public ContrôleurCliqueEnfoncé(Application application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}
	
	@Override
	public void traitementPosition() {
		for (Bille bille : application.billes) {
			System.out.println(bille.getPosition());
			Vecteur diff = Vecteur.difference(bille.getPosition(), pos);
			double nDiffCarée = diff.normeCarrée(), rayon = bille.getRayon() + 1., rayonCarrée = rayon * rayon;
			
			if (nDiffCarée < rayonCarrée)
				System.out.println("Clique sur la bille " + bille.getCouleur().toString());
		}
	}
}
