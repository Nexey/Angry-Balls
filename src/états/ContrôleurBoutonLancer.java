package états;

import main.AnimationBilles;
import main.ApplicationContrôlée;
import modele.BoutonAvecIcones;

public class ContrôleurBoutonLancer extends ContrôleurBouton {

	public ContrôleurBoutonLancer(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContrôlée application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBoutonLancer(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(source, animationBilles, application, suivant, retour);
	}

	/**
	 * Lance l'animation et mets à jour l'icone de jeu
	 */
	@Override
	public void traite() {
		this.animationBilles.lancerAnimation();
		this.source.setIcon(this.source.getIcone("Arrêter"));
	}
}
