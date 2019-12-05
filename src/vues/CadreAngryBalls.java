package vues;

import java.awt.*;
import java.util.Vector;

import javax.swing.JFrame;

import modele.Bille;
import modele.BoutonAvecIcones;
import outilsvues.EcouteurTerminaison;

import outilsvues.Outils;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrôle (arrêt du
 * programme, lancer les billes, arréter les billes)
 * 
 * ICI : IL N'Y A RIEN A CHANGER
 * 
 * 
 */
public class CadreAngryBalls extends JFrame implements VueBillard {
	TextField présentation;
	public Billard billard;
//	public Button boutonJeu, arrêterBilles;
	Panel haut, centre, bas;
	public BoutonAvecIcones boutonJeu;

	EcouteurTerminaison ecouteurTerminaison;

	public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException {
		super(titre);
		Outils.place(this, 0.33, 0.33, 0.5, 0.5);
		
		this.ecouteurTerminaison = new EcouteurTerminaison(this);

		this.haut = new Panel();
		this.haut.setBackground(Color.LIGHT_GRAY);
		this.add(this.haut, BorderLayout.NORTH);

		this.centre = new Panel();
		this.add(this.centre, BorderLayout.CENTER);

		this.bas = new Panel();
		this.bas.setBackground(Color.LIGHT_GRAY);
		this.add(this.bas, BorderLayout.SOUTH);

		this.présentation = new TextField(message, 100);
		this.présentation.setEditable(false);
		this.haut.add(this.présentation);

		this.billard = new Billard(billes);
		this.add(this.billard);

		this.boutonJeu = new BoutonAvecIcones();
		this.bas.add(this.boutonJeu);
		//this.boutonJeu = new Button("lancer les billes");
		//this.arrêterBilles = new Button("arrêter les billes");
		//this.bas.add(this.arrêterBilles);

	}

	public double largeurBillard() {
		return this.billard.getWidth();
	}

	public double hauteurBillard() {
		return this.billard.getHeight();
	}

	@Override
	public void miseAJour() {
		this.billard.repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exodecorateur.vues.VueBillard#montrer()
	 */
	@Override
	public void montrer() {
		this.setVisible(true);
	}

}