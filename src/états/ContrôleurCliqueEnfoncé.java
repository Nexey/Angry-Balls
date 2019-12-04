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
	public void traitementPosition() {
		for (Bille bille : application.billes) {
			System.out.println(bille.getPosition());
			Vecteur diff = Vecteur.difference(bille.getPosition(), pos);
			double	normeDiffCar�e = diff.normeCarr�e(),
					rayon = bille.getRayon() + 1.,
					rayonCarr�e = rayon * rayon;
			
			if (normeDiffCar�e < rayonCarr�e)
				System.out.println("Clique sur la bille " + bille.getCouleur().toString());
		}
	}
}
