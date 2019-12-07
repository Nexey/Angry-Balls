package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JTextField;

import décorateurs.*;
import mesmaths.geometrie.base.Vecteur;
import vues.CadreAngryBalls;
import vues.VueBillard;
import modele.*;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * différent
 * 
 * Idéal pour mettre en place le DP decorator
 */
public class TestAngryBalls {

	public static Vecteur centreAléatoire(double xMax, double yMax) {
		return Vecteur.créationAléatoire(0, 0, xMax, yMax);
	}

	public static Vecteur vitesseAléatoire(double vMax) {
		return Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//------------------- création de la liste (pour l'instant vide) des billes -----------------------

		Vector<Bille> billes = new Vector<Bille>();

//---------------- création de la vue responsable du dessin des billes -------------------------

		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls", "Animation de billes ayant des comportements différents. Situation idéale pour mettre en place le DP Decorator", billes);
		cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------

		double xMax, yMax;
		double vMax = 0.05;
		xMax = cadre.largeurBillard(); // abscisse maximal
		yMax = cadre.hauteurBillard(); // ordonnée maximale

		double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le même rayon, mais
													// ce n'est pas obligatoire

		Vecteur p0, p1, p2, p3, p4, v0, v1, v2, v3, v4; // les positions des centres des billes et les vecteurs vitesse
														// au démarrage.
														// Elles vont être choisies aléatoirement

//------------------- création des vecteurs position des billes ---------------------------------

		// p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p0 = new Vecteur(0.0, 0.0);
		p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
		p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

		double scale = 20;
		Vecteur p5 = new Vecteur(3 * xMax / scale, 10 * yMax / scale);
		/*
		Vecteur p6 = new Vecteur(5. * xMax / scale, 5 * yMax / scale);
		Vecteur p7 = new Vecteur(6. * xMax / scale, 5 * yMax / scale);
		Vecteur p8 = new Vecteur(7. * xMax / scale, 5 * yMax / scale);
		Vecteur p9 = new Vecteur(6. * xMax / scale, 3 * yMax / scale);
		Vecteur p10 = new Vecteur(7. * xMax / scale, 3 * yMax / scale);
		Vecteur p11 = new Vecteur(7. * xMax / scale, 1 * yMax / scale);

		Vecteur p12 = new Vecteur(6. * xMax / scale, 7 * yMax / scale);
		Vecteur p13 = new Vecteur(7. * xMax / scale, 7 * yMax / scale);
		Vecteur p14 = new Vecteur(7. * xMax / scale, 9 * yMax / scale);
		*/

		Vecteur p6 = new Vecteur(5. * xMax / scale, 5 * yMax / scale);
		Vecteur p7 = new Vecteur(6. * xMax / scale, 5 * yMax / scale);
		Vecteur p8 = new Vecteur(7. * xMax / scale, 5 * yMax / scale);
		Vecteur p9 = new Vecteur(8. * xMax / scale, 5 * yMax / scale);
		Vecteur p10 = new Vecteur(9. * xMax / scale, 5 * yMax / scale);
		Vecteur p11 = new Vecteur(10. * xMax / scale, 5 * yMax / scale);
		Vecteur p12 = new Vecteur(11. * xMax / scale, 5 * yMax / scale);
		Vecteur p13 = new Vecteur(12. * xMax / scale, 5 * yMax / scale);
		Vecteur p14 = new Vecteur(13. * xMax / scale, 5 * yMax / scale);

//------------------- création des vecteurs vitesse des billes ---------------------------------

		v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- création des billes ---------------------------------

		// Bille qui rebondit
		// billes.add(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.black)));

		// Bille qui poursuit les autres
		// billes.add(new BilleNewton(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.green))));

		// Billes passe muraille avec une qui a du frottement
		// billes.add(new BillePasseMuraille(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.cyan)));
		// billes.add(new BilleFrottement(new BillePasseMuraille(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.blue))));

		// Bille qui a de la pesanteur ET du frottement
		// billes.add(new BilleFrottement(new BillePesanteur(new Vecteur(0, 0.001), new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.white)))));

		// Bille qui a un arrêt et qui est newton
		// billes.add(new BilleNewton(new BilleArrêt(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.gray)))));
		// Bille pilotée
		Bille billeLancePierreRose = new BillePilotée(/* new BillePesanteur(new Vecteur(0, 0.001), */ new BilleVoleuseDeTaille(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p5, rayon * 2, Color.pink)))))/* ) */;
		billes.add(billeLancePierreRose);
		
		/*
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p6, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p7, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p8, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p9, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p10, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p11, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p12, rayon, Color.black))));
		billes.add(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p13, rayon, Color.black))));
		billes.add(new BilleMalade(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p14, rayon, Color.blue)))));
		// */
		
		//billes.add(new BilleNewton(new BilleVoleuseDeTaille(0.2, new BilleArrêt(new BilleParDéfaut(p6, rayon, Color.black)))));
		/*
		for (int x = 6; x < 32; x++) {
			for (int y = 5; y < 29; y = y+2) {
				billes.add(new BilleRebond(new BilleFrottement(new BilleRebond(new BilleParDéfaut(new Vecteur(x * xMax / scale, y * yMax / scale), rayon, Color.black)))));
			}
		}
		// */

// */
//---------------------- ici finit la partie à changer -------------------------------------------------------------

		System.out.println("billes = " + billes);

//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

		AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
		ApplicationContrôlée app = new ApplicationContrôlée(billes, animationBilles, cadre);
		app.addObserver((Observer) billeLancePierreRose);
	}

}
