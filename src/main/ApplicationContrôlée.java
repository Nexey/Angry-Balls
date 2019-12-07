package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import modele.InfoClique;
import vues.Application;
import vues.CadreAngryBalls;
import �tats.Contr�leurBoutonArr�ter;
import �tats.Contr�leurBoutonLancer;
import �tats.Contr�leurCliqueBillard;
import �tats.Contr�leur�tat;

/* Cette classe se charge de rajouter les observeurs sur l'application */

/**
 * 
 * Permet de d�charger le main d'une grosse partie des donn�es
 * C'est cette classe qui g�n�re les donn�es sur les aspects du jeu (comme les boutons)
 * 
 */
public class ApplicationContr�l�e extends Application implements MouseInputListener, ActionListener {
	protected Contr�leur�tat contr�leurBoutonCourant;
	protected Contr�leur�tat contr�leurCliqueCourant;
	protected Contr�leurCliqueBillard contr�leurCliqueBillard;
	protected Contr�leurBoutonLancer contr�leurBoutonLancer;
	protected Contr�leurBoutonArr�ter contr�leurBoutonArr�ter;
	protected AnimationBilles animationBilles;
	protected boolean jeuLanc�;

	public ApplicationContr�l�e(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		this.animationBilles = animationBilles;
		this.jeuLanc� = false;
		cadreAngryBalls.billard.addMouseListener(this);
		cadreAngryBalls.billard.addMouseMotionListener(this);
		cadreAngryBalls.boutonJeu.addActionListener(this);

		cadreAngryBalls.boutonJeu.addIcone("Lancer", new ImageIcon("src/assets/lancer.png"));
		cadreAngryBalls.boutonJeu.addIcone("Arr�ter", new ImageIcon("src/assets/pause.png"));
		cadreAngryBalls.boutonJeu.setIcon(cadreAngryBalls.boutonJeu.getIcone("Lancer"));
		cadreAngryBalls.boutonJeu.setFocusPainted(false);
		cadreAngryBalls.boutonJeu.setBorderPainted(false);
		installeContr�leurs(cadreAngryBalls);
	}
	
	/**
	 * @param cadreAngryBalls     le cadre contenant le jeu
	 * construit le graphe orient� correspondant au diagramme de transition d'�tats.
	 * Rappelons que chaque �tat est g�r� par un contr�leur d'�tat. Il faut donc
	 * autant de contr�leurs que d'�tats + le contr�leur courant
	 */
	private void installeContr�leurs(CadreAngryBalls cadreAngryBalls) {
		this.contr�leurCliqueBillard = new Contr�leurCliqueBillard(this);
		this.contr�leurCliqueBillard.setSuivant(contr�leurCliqueBillard);
		this.contr�leurCliqueBillard.setRetour(contr�leurCliqueBillard);
		this.setContr�leurCliqueCourant(contr�leurCliqueBillard);
		
		this.contr�leurBoutonLancer = new Contr�leurBoutonLancer(cadreAngryBalls.boutonJeu, this.animationBilles, this);
		this.contr�leurBoutonArr�ter = new Contr�leurBoutonArr�ter(cadreAngryBalls.boutonJeu, this.animationBilles, this, contr�leurBoutonLancer, contr�leurBoutonLancer);
		this.contr�leurBoutonLancer.setSuivant(this.contr�leurBoutonArr�ter);
		this.contr�leurBoutonLancer.setRetour(this.contr�leurBoutonArr�ter);
		this.setContr�leurBoutonCourant(contr�leurBoutonLancer);
	}

	public boolean isJeuLanc�() {
		return jeuLanc�;
	}

	public void setJeuLanc�(boolean jeuLanc�) {
		this.jeuLanc� = jeuLanc�;
	}
	
	public void majJeu() {
		this.jeuLanc� = !this.jeuLanc�;
	}
	
	public Contr�leur�tat getContr�leurBoutonCourant() {
		return contr�leurBoutonCourant;
	}

	public void setContr�leurBoutonCourant(Contr�leur�tat contr�leurBoutonCourant) {
		this.contr�leurBoutonCourant = contr�leurBoutonCourant;
	}

	public Contr�leur�tat getContr�leurCliqueCourant() {
		return contr�leurCliqueCourant;
	}

	public void setContr�leurCliqueCourant(Contr�leur�tat contr�leurCliqueCourant) {
		this.contr�leurCliqueCourant = contr�leurCliqueCourant;
	}
	
	public Vecteur getCoordsMouseEvent(MouseEvent e) {
		return new Vecteur(e.getX(), e.getY());
	}
	
	protected void posHandler(InfoClique clique) {
		this.setChanged();
		this.notifyObservers(clique);
		this.contr�leurCliqueCourant.actionD�tect�e(clique);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		InfoClique infoClique = new InfoClique(InfoClique.PRESSE_INITIALE, this.getCoordsMouseEvent(e));
		this.posHandler(infoClique);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		InfoClique infoClique = new InfoClique(InfoClique.RELACH�, this.getCoordsMouseEvent(e));
		this.posHandler(infoClique);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		InfoClique infoClique = new InfoClique(InfoClique.PRESS�_BOUGEANT, this.getCoordsMouseEvent(e));
		this.posHandler(infoClique);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.contr�leurBoutonCourant.actionD�tect�e(e);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e) {}
}
