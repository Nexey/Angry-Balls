package visiteurs;

import mesmaths.cinematique.Cinematique;
import modele.Bille;

public class VisiteurD�placementBille implements IVisiteur {
	double deltaT;
	
	public VisiteurD�placementBille(double deltaT) {
		this.deltaT = deltaT;
	}
	
	@Override
	public boolean visite(Bille bille) {
		Cinematique.mouvementUniform�mentAcc�l�r�(bille.getPosition(), bille.getVitesse(), bille.getAcc�l�ration(), deltaT);
		return true;
	}

}
