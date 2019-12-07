package visiteurs;

import java.awt.Color;
import java.awt.Graphics;

import modele.Bille;

/**
 * 
 * Le visiteur de dessin
 * Comme la bille n'est pas censé être un objet graphique,
 * je fais de ce visiteur l'objet graphique qui peut dessiner une bille
 * 
 */
public class VisiteurDessinBille implements IVisiteur {
	protected Graphics graphics;
	
	public VisiteurDessinBille(Graphics graphics) {
		this.graphics = graphics;
	}

	/**
	 * @param bille     la bille à dessiner
	 * Utilise les données de la bille pour l'afficher à l'écran
	 */
	@Override
	public boolean visite(Bille bille) {
		int width, height;
		int xMin, yMin;

		xMin = (int) Math.round(bille.getPosition().x - bille.getRayon());
		yMin = (int) Math.round(bille.getPosition().y - bille.getRayon());

		width = height = 2 * (int) Math.round(bille.getRayon());

		this.graphics.setColor(bille.getCouleur());
		this.graphics.fillOval(xMin, yMin, width, height);
		this.graphics.setColor(Color.CYAN);
		this.graphics.drawOval(xMin, yMin, width, height);
		return true;
	}

}
