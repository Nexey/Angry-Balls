package états;

import java.awt.Button;

import main.AnimationBilles;
import main.ApplicationContrôlée;
import modele.BoutonAvecIcones;

public class ContrôleurBoutonArrêter extends ContrôleurBouton {

	public ContrôleurBoutonArrêter(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContrôlée application) {
		this(source, animationBilles, application, null, null);
	}

	public ContrôleurBoutonArrêter(BoutonAvecIcones source, AnimationBilles animationBilles, ApplicationContrôlée application, ContrôleurÉtat suivant, ContrôleurÉtat retour) {
		super(source, animationBilles, application, suivant, retour);
	}

	/**
	 * Arrête l'animation et mets à jour l'icone de jeu
	 */
	@Override
	public void traite() {
		this.animationBilles.arrêterAnimation();
		this.source.setIcon(this.source.getIcone("Lancer"));
	}
}