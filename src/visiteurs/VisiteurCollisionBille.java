package visiteurs;

import java.util.Vector;

import modele.Bille;
import modele.OutilsBille;

public class VisiteurCollisionBille implements IVisiteur {
	Vector<Bille> billes;
	
	public VisiteurCollisionBille(Vector<Bille> billes) {
		this.billes = billes;
	}

	@Override
	public boolean visite(Bille bille) {
		return OutilsBille.gestionCollisionBilleBille(bille, billes);
	}

}
