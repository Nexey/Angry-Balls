package décorateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BillePilotée extends BilleCliquableDéplaçable {
	
	public BillePilotée(Bille billeDécorée) {
		super(billeDécorée);
	}

	@Override
	public void gérerPresseMouvement(InfoClique infoClique) {
		this.effectuerDéplacementAuClique(infoClique);
	}

	@Override
	public String toString() {
		return "bille pillotée - " + this.billeDécorée.toString();
	}
}
