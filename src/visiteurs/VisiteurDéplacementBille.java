package visiteurs;

import mesmaths.cinematique.Cinematique;
import modele.Bille;

public class VisiteurDéplacementBille implements IVisiteur {
	double deltaT;
	
	public VisiteurDéplacementBille(double deltaT) {
		this.deltaT = deltaT;
	}
	
	@Override
	public boolean visite(Bille bille) {
		Cinematique.mouvementUniformémentAccéléré(bille.getPosition(), bille.getVitesse(), bille.getAccélération(), deltaT);
		return true;
	}

}
