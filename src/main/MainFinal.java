package main;

import java.awt.Color;
import java.util.Observer;
import java.util.Vector;

import d�corateurs.BilleArr�t;
import d�corateurs.BilleFrottement;
import d�corateurs.BilleLancePierre;
import d�corateurs.BilleNewton;
import d�corateurs.BillePasseMuraille;
import d�corateurs.BillePesanteur;
import d�corateurs.BillePilot�e;
import d�corateurs.BilleRebond;
import d�corateurs.BilleVoleuseDeTaille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.BilleParD�faut;
import vues.CadreAngryBalls;

public class MainFinal {

	public static void main(String[] args) {
		//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------

				Vector<Bille> billes = new Vector<Bille>();

		//---------------- cr�ation de la vue responsable du dessin des billes -------------------------

				CadreAngryBalls cadre = new CadreAngryBalls("Angry balls", "Animation de billes ayant des comportements diff�rents. Situation id�ale pour mettre en place le DP Decorator", billes);
				cadre.montrer(); // on rend visible la vue

		//------------- remplissage de la liste avec 4 billes -------------------------------

				double xMax, yMax;
				double vMax = 0.05;
				xMax = cadre.largeurBillard(); // abscisse maximal
				yMax = cadre.hauteurBillard(); // ordonn�e maximale

				double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais
															// ce n'est pas obligatoire

				Vecteur p0, p1, p2, p3, p4, p5, p6, v0, v1, v2, v3, v4; // les positions des centres des billes et les vecteurs vitesse
																// au d�marrage.
																// Elles vont �tre choisies al�atoirement

		//------------------- cr�ation des vecteurs position des billes ---------------------------------

				p0 = new Vecteur(0.0, 0.0);
				p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
				p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
				p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
				p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
				
				// Pour la bille qui est pillotable
				p5 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
				
				// Pour la bille lance-pierre
				p6 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);

		//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------

				v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
				v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
				v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
				v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
				v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);

		//--------------- cr�ation des billes ---------------------------------

				// Bille qui rebondit
				billes.add(new BilleRebond(new BilleParD�faut(p0, rayon, v0, Color.black)));
				
				// Bille qui a du frottement et qui est soumise � la pesanteur
				billes.add(new BilleRebond(new BilleFrottement(new BillePesanteur(new Vecteur(0, 0.001), new BilleParD�faut(p1, rayon, v1, Color.gray)))));

				// Bille qui poursuit les autres
				billes.add(new BilleNewton(new BilleArr�t(new BilleParD�faut(p2, rayon, v2, Color.green))));

				// Bille passe muraille
				billes.add(new BillePasseMuraille(new BilleParD�faut(p3, rayon, v3, Color.cyan)));
				
				// Bille qui poursuit les autres et qui a du frottement 
				billes.add(new BilleNewton(new BilleFrottement(new BilleRebond(new BilleParD�faut(p4, rayon, v4, Color.green)))));
				
				// Bille qui est pillotable (rose de petite taille) qui a du frottement pour pouvoir la r�cup�rer facilement
				Bille billePilotable = new BillePilot�e(new BilleFrottement(new BilleRebond(new BilleParD�faut(p5, rayon / 2, Color.pink))));
				billes.add(billePilotable);
				
				// BONUS : Une bille qui peut �tre catapult�e comme sur un lance pierre
				// quand elle rentre dans une bille elle lui vole une partie de son rayon
				Bille billeLancePierreVoleuse = new BilleLancePierre(new BilleFrottement(new BilleVoleuseDeTaille(new BilleRebond(new BilleParD�faut(p6, rayon, Color.red)))));
				billes.add(billeLancePierreVoleuse);
				
		//---------------------- ici finit la partie � changer -------------------------------------------------------------

				System.out.println("billes = " + billes);

		//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

				AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
				ApplicationContr�l�e app = new ApplicationContr�l�e(billes, animationBilles, cadre);
				app.addObserver((Observer) billePilotable);
				app.addObserver((Observer) billeLancePierreVoleuse);
	}

}
