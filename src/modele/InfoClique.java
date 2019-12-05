package modele;

import mesmaths.geometrie.base.Vecteur;

public class InfoClique {
	protected boolean pressed;
	protected boolean released;
	protected Vecteur positionClique;
	
	public Vecteur getPositionClique() {
		return positionClique;
	}

	public InfoClique(Vecteur positionClique) {
		this.positionClique = positionClique;
	}
	
	/*
	protected void setTrueFalse(boolean toTrue, boolean toFalse) {
		toTrue = true;
		toFalse = false;
	}
	*/
	
	public void updatePressed() {
		this.pressed = true;
		this.released = false;
	}
	
	public void updateReleased() {
		this.pressed = false;
		this.released = true;
	}
	
	public boolean isPressed() {
		return this.pressed;
	}
	
	public boolean isReleased() {
		return this.released;
	}
}
