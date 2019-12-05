package vues;

import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JPanel;

import modele.Bille;
import visiteurs.IVisiteur;
import visiteurs.VisiteurDessinBille;

/**
 * responsable du dessin des billes
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 */
@SuppressWarnings("serial")
public class Billard extends JPanel {
	Vector<Bille> billes;

	public Billard(Vector<Bille> billes) {
		super();
		this.billes = billes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Canvas#paint(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		IVisiteur visiteurDessin = new VisiteurDessinBille(graphics);
		int i;

		for (i = 0; i < this.billes.size(); ++i)
			this.billes.get(i).accepte(visiteurDessin);
		
		// System.out.println("billes dans le billard = " + billes);
	}

}
