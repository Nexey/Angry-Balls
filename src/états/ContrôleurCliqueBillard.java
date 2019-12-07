package états;

import main.ApplicationContrôlée;
import modele.InfoClique;

/**
 * Le contrôleur par défaut des cliques sur le billard
 * Le traitementPosition ne fait rien de plus que le clique par défaut sauf pour l'action détectée
 * 
 */
public class ContrôleurCliqueBillard extends ContrôleurClique {

	public ContrôleurCliqueBillard(ApplicationContrôlée application) {
		this(application, null, null);
	}

	public ContrôleurCliqueBillard(ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(application, suivant, retour);
	}

	/**
	 * @param e      l'objet passé lors de l'événement
	 */
	@Override
	public void actionDétectée(Object e) {
		if (this != this.application.getContrôleurCliqueCourant())
			return;
		if (e instanceof InfoClique) {
			this.pos = ((InfoClique) e).getPositionClique();
			traite();
		}
	}

	@Override
	public void traitementPosition() {}
}
