package décorateurs;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import modele.Bille;
import modele.BilleParDéfaut;
import modele.OutilsBille;

public class BilleMalade extends DécorateurBille {

	public BilleMalade(Bille billeDécorée) {
		super(billeDécorée);
	}



	/**
	 * @param billes		la liste de billes à tester pour voir laquelle rendre malade
	 */
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		boolean resu = super.gestionCollisionBilleBille(billes);
		
		if (resu) {
			Vector<Bille> autreBille = OutilsBille.autresBilles(this, billes);
			for (Bille bille : autreBille) {
				if (Geop.intersectionCercleCercle(this.getPosition(), this.getRayon()*2, bille.getPosition(), bille.getRayon())) {
					billes.add(new BilleMalade(bille));
					bille.setCouleur(Color.green);
					billes.remove(bille);
				}
			}
		}
		return resu;
	}
}
