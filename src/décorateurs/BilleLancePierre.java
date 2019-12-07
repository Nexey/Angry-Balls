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
	public void gérerPresseMouvement(InfoClique infoClique) {}

	/**
	 * @param infoClique
	 */
	@Override
	public void gérerRelaché(InfoClique infoClique) {
		this.effectuerDéplacementAuClique(infoClique);
		super.gérerRelaché(infoClique);
	}

	@Override
	public String toString() {
		return "bille lance-pière - " + this.billeDécorée.toString();
	}

	/**
	 * @param direction		la direction à suivre
	 */
	@Override
	public Vecteur appliquerVecteurVitesse(Vecteur direction) {
		Vecteur nouvelleVitesse = new Vecteur(0, 0);
		nouvelleVitesse.x = direction.x / 10000;
		nouvelleVitesse.y = direction.y / 10000;
		return nouvelleVitesse;
	}
}