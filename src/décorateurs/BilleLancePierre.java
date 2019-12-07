package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BilleLancePierre extends BilleCliquableDéplaçable {

	public BilleLancePierre(Bille billeDécorée) {
		super(billeDécorée);
	}
	@Override
	public void gérerRelaché(InfoClique infoClique) {
		this.effectuerDéplacementAuClique(infoClique);
		super.gérerRelaché(infoClique);
	}

	@Override
	public String toString() {
		return "bille lance-pière - " + this.billeDécorée.toString();
	}
}