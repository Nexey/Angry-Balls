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
		double vMax = 0.1;
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

//------------------- création des vecteurs vitesse des billes ---------------------------------

		v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie à changer ---------------------------------
		/*
		billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
		billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0, 0.001), Color.yellow));
		billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
		billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
		billes.add(new BilleMvtNewtonArret(p4, rayon, v4, Color.black)); // */
		
		
		// Bille qui rebondit
		billes.add(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.black)));
		System.out.println(billes.get(0).getPosition());

		// Bille qui poursuit les autres
		billes.add(new BilleNewton(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.green))));

		// Billes passe muraille avec une qui a du frottement
		billes.add(new BillePasseMuraille(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.cyan)));
		billes.add(new BilleFrottement(new BillePasseMuraille(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.blue))));

		// Bille qui a de la pesanteur ET du frottement
		billes.add(new BilleFrottement(new BillePesanteur(new Vecteur(0, 0.001), new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.white)))));

		// Bille qui a un arrêt et qui est newton
		billes.add(new BilleNewton(new BilleArrêt(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.gray)))));

		// Bille pilotée
		Bille billePilotéeRose = new BillePilotée(new BilleRebond(new BilleParDéfaut(centreAléatoire(xMax, yMax), rayon, vitesseAléatoire(vMax), Color.pink)));
		billes.add(billePilotéeRose);

// */
//---------------------- ici finit la partie à changer -------------------------------------------------------------

		System.out.println("billes = " + billes);

//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

		AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
		ApplicationContrôlée app = new ApplicationContrôlée(billes, animationBilles, cadre);
		app.addObserver((Observer) billePilotéeRose);

//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------

//		EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
//		EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------

//		cadre.lancerBilles.addActionListener(écouteurBoutonLancer); // maladroit : à changer
//		cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter); // maladroit : à changer
	}

}
