package d�corateurs;

import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;

public class BillePilot�e extends BilleCliquableD�pla�able {
	
	public BillePilot�e(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}

	@Override
	public void g�rerPresseMouvement(InfoClique infoClique) {
		this.effectuerD�placementAuClique(infoClique);
	}

	@Override
	public String toString() {
		return "bille pillot�e - " + this.billeD�cor�e.toString();
	}
}
