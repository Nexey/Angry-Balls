package main;

import java.awt.Color;
import java.util.Observer;
import java.util.Vector;

import décorateurs.BilleArrêt;
import décorateurs.BilleFrottement;
import décorateurs.BilleLancePierre;
import décorateurs.BilleNewton;
import décorateurs.BillePasseMuraille;
import décorateurs.BillePesanteur;
import décorateurs.BillePilotée;
import décorateurs.BilleRebond;
import décorateurs.BilleVoleuseDeTaille;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.BilleParDéfaut;
import vues.CadreAngryBalls;

public class MainFinal {

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

				Vecteur p0, p1, p2, p3, p4, p5, p6, v0, v1, v2, v3, v4; // les positions des centres des billes et les vecteurs vitesse
																// au démarrage.
																// Elles vont être choisies aléatoirement

		//------------------- création des vecteurs position des billes ---------------------------------

				p0 = new Vecteur(0.0, 0.0);
				p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
				p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
				p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
				p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
				
				// Pour la bille qui est pillotable
				p5 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
				
				// Pour la bille lance-pierre
				p6 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

		//------------------- création des vecteurs vitesse des billes ---------------------------------

				v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
				v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
				v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
				v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
				v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

		//--------------- création des billes ---------------------------------

				// Bille qui rebondit
				billes.add(new BilleRebond(new BilleParDéfaut(p0, rayon, v0, Color.black)));
				
				// Bille qui a du frottement et qui est soumise à la pesanteur
				billes.add(new BilleRebond(new BilleFrottement(new BillePesanteur(new Vecteur(0, 0.001), new BilleParDéfaut(p1, rayon, v1, Color.gray)))));

				// Bille qui poursuit les autres
				billes.add(new BilleNewton(new BilleArrêt(new BilleParDéfaut(p2, rayon, v2, Color.green))));

				// Bille passe muraille
				billes.add(new BillePasseMuraille(new BilleParDéfaut(p3, rayon, v3, Color.cyan)));
				
				// Bille qui poursuit les autres et qui a du frottement 
				billes.add(new BilleNewton(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p4, rayon, v4, Color.green)))));
				
				// Bille qui est pillotable (rose de petite taille) qui a du frottement pour pouvoir la récupérer facilement
				Bille billePilotable = new BillePilotée(new BilleFrottement(new BilleRebond(new BilleParDéfaut(p5, rayon / 2, Color.pink))));
				billes.add(billePilotable);
				
				// BONUS : Une bille qui peut être catapultée comme sur un lance pierre
				// quand elle rentre dans une bille elle lui vole une partie de son rayon
				Bille billeLancePierreVoleuse = new BilleLancePierre(new BilleFrottement(new BilleVoleuseDeTaille(new BilleRebond(new BilleParDéfaut(p6, rayon, Color.red)))));
				billes.add(billeLancePierreVoleuse);
				
		//---------------------- ici finit la partie à changer -------------------------------------------------------------

				System.out.println("billes = " + billes);

		//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

				AnimationBilles animationBilles = new AnimationBilles(billes, cadre);
				ApplicationContrôlée app = new ApplicationContrôlée(billes, animationBilles, cadre);
				app.addObserver((Observer) billePilotable);
				app.addObserver((Observer) billeLancePierreVoleuse);
	}

}
