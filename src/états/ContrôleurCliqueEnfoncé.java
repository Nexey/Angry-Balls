package �tats;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Application;

public class Contr�leurCliqueEnfonc� extends Contr�leur�tat {

	public Contr�leurCliqueEnfonc�(Application application) {
		this(application, null, null);
	}

	public Contr�leurCliqueEnfonc�(Application application, Contr�leur�tat suivant, Contr�leur�tat retour) {
		super(application, suivant, retour);
	}

	@Override
	public void actionD�tect�e(Vecteur pos) {
		if (this != application.getControleurCourant())
			return;
		System.out.println("clic enfonc� en " + pos);
		traite(pos);
	}

	@Override
	public void traite(Vecteur pos) {
		for (Bille bille : application.billes) {
			System.out.println(bille.getPosition());
			Vecteur diff = Vecteur.difference(bille.getPosition(), pos);
			double	nDiffCar�e = diff.normeCarr�e(),
					rayon = bille.getRayon() + 1.,
					rayonCarr�e = rayon * rayon;

			if (nDiffCar�e < rayonCarr�e) System.out.println("Clique sur la bille " + bille.getCouleur().toString());

		}
		this.�tatSuivant();
	}

	@Override
	public void surChangement�tat() {

	}
}
