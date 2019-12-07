package modele;

import mesmaths.geometrie.base.Vecteur;

public class InfoClique {
	protected int typeDeClique;
	protected Vecteur positionClique;

	public static final int PRESSE_INITIALE = 1, PRESSÉ_BOUGEANT = 2, RELACHÉ = 3;

	// Hypothèse : PRESSE_INITIALE <= typeDeClique <= RELACHÉ
	public InfoClique(int typeDeClique, Vecteur positionClique) {
		this.typeDeClique = typeDeClique;
		this.positionClique = positionClique;
	}

	public int getTypeDeClique() {
		return typeDeClique;
	}

	public Vecteur getPositionClique() {
		return positionClique;
	}

	@Override
	public String toString() {
		return "Info clique [type : " + typeDeClique + ", pos :" + positionClique + "]";
	}
}