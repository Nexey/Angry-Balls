package modele;

import mesmaths.geometrie.base.Vecteur;

public class InfoClique {
	protected int typeDeClique;
	protected Vecteur positionClique;

	public static final int PRESSE_INITIALE = 1, PRESS�_BOUGEANT = 2, RELACH� = 3;

	// Hypoth�se : PRESSE_INITIALE <= typeDeClique <= RELACH�
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