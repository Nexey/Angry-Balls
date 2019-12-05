package main;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JTextField;

import d�corateurs.*;
import mesmaths.geometrie.base.Vecteur;
import vues.CadreAngryBalls;
import vues.VueBillard;
import modele.*;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement
 * diff�rent
 * 
 * Id�al pour mettre en place le DP decorator
 */
public class TestAngryBalls {

	public static Vecteur centreAl�atoire(double xMax, double yMax) {
		return Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
	}

	public static Vecteur vitesseAl�atoire(double vMax) {
		return Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------

		Vector<Bille> billes = new Vector<Bille>();

//---------------- cr�ation de la vue responsable du dessin des billes -------------------------

		CadreAngryBalls cadre = new CadreAngryBalls("Angry balls", "Animation de billes ayant des comportements diff�rents. Situation id�ale pour mettre en place le DP Decorator", billes);
		cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------

		double xMax, yMax;
		double vMax = 0.1;
		xMax = cadre.largeurBillard(); // abscisse maximal
		yMax = cadre.hauteurBillard(); // ordonn�e maximale

		double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais
													// ce n'est pas obligatoire

		Vecteur p0, p1, p2, p3, p4, v0, v1, v2, v3, v4; // les positions des centres des billes et les vecteurs vitesse
														// au d�marrage.
														// Elles vont �tre choisies al�atoirement

//------------------- cr�ation des vecteurs position des billes ---------------------------------

		// p0 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p0 = new Vecteur(0.0, 0.0);
		p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
		p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);

//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------

		v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
		v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
		v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie � changer ---------------------------------
		/*
		billes.add(new BilleMvtRURebond(p0, rayon, v0, Color.red));
		billes.add(new BilleMvtPesanteurFrottementRebond(p1, rayon, v1, new Vecteur(0, 0.001), Color.yellow));
		billes.add(new BilleMvtNewtonFrottementRebond(p2, rayon, v2, Color.green));
		billes.add(new BilleMvtRUPasseMurailles(p3, rayon, v3, Color.cyan));
		billes.add(new BilleMvtNewtonArret(p4, rayon, v4, Color.black)); // */
		
		
		// Bille qui rebondit
		billes.add(new BilleRebond(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.black)));
		System.out.println(billes.get(0).getPosition());

		// Bille qui poursuit les autres
		billes.add(new BilleNewton(new BilleRebond(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.green))));

		// Billes passe muraille avec une qui a du frottement
		billes.add(new BillePasseMuraille(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.cyan)));
		billes.add(new BilleFrottement(new BillePasseMuraille(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.blue))));

		// Bille qui a de la pesanteur ET du frottement
		billes.add(new BilleFrottement(new BillePesanteur(new Vecteur(0, 0.001), new BilleRebond(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.white)))));

		// Bille qui a un arr�t et qui est newton
		billes.add(new BilleNewton(new BilleArr�t(new BilleRebond(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.gray)))));

		// Bille pilot�e
		Bille billePilot�eRose = new BillePilot�e(new BilleRebond(new BilleParD�faut(centreAl�atoire(xMax, yMax), rayon, vitesseAl�atoire(vMax), Color.pink)));
		billes.add(billePilot�eRose);

// */
//---------------------- ici finit la partie � changer -------------------------------------------------------------

		System.out.println("billes = " + billes);

//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

		AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
		ApplicationContr�l�e app = new ApplicationContr�l�e(billes, animationBilles, cadre);
		app.addObserver((Observer) billePilot�eRose);

//----------------------- mise en place des �couteurs de boutons qui permettent de contr�ler (un peu...) l'application -----------------

//		EcouteurBoutonLancer �couteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
//		EcouteurBoutonArreter �couteurBoutonArr�ter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des �couteurs des boutons et �a tourne tout seul ------------------------------

//		cadre.lancerBilles.addActionListener(�couteurBoutonLancer); // maladroit : � changer
//		cadre.arr�terBilles.addActionListener(�couteurBoutonArr�ter); // maladroit : � changer
	}

}