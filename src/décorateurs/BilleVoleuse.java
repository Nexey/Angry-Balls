package décorateurs;

import java.awt.Color;
import java.util.Vector;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.BilleParDéfaut;
import modele.OutilsBille;

public class BilleVoleuse extends DécorateurBille {

	public BilleVoleuse(Bille billeDécorée) {
		super(billeDécorée);
	}

	
	// Grosse redondance avec BilleMalade, c'est plus pour l'aspect drôle que j'ai fait ceci
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		boolean resu = super.gestionCollisionBilleBille(billes);
		
		if (resu) {
			Vector<Bille> autreBille = OutilsBille.autresBilles(this, billes);
			for (Bille bille : autreBille) {
				if (Geop.intersectionCercleCercle(this.getPosition(), this.getRayon()*2, bille.getPosition(), bille.getRayon())) {
					Vecteur temp = new Vecteur(this.getPosition());
					this.getPosition().set(new Vecteur(bille.getPosition()));
					bille.getPosition().set(temp);
				}
			}
		}
		return resu;
	}
}
