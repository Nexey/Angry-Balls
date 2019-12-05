package d�corateurs;

import java.awt.Color;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import modele.Bille;
import modele.BilleParD�faut;
import modele.OutilsBille;

public class BilleMalade extends D�corateurBille {

	public BilleMalade(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}


	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		boolean resu = super.gestionCollisionBilleBille(billes);
		
		if (resu) {
			Vector<Bille> autreBille = OutilsBille.autresBilles(this, billes);
			for (Bille bille : autreBille) {
				if (Geop.intersectionCercleCercle(this.getPosition(), this.getRayon()*2, bille.getPosition(), bille.getRayon())) {
					billes.add(new BilleMalade(new BilleRebond(new BilleParD�faut(bille.getPosition(), bille.getRayon(), bille.getVitesse(), bille.getAcc�l�ration(), Color.green))));
					billes.remove(bille);
				}
			}
		}
		return resu;
	}
}
