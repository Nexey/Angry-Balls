package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.event.MouseInputListener;

import modele.Bille;
import vues.Application;
import vues.CadreAngryBalls;
import �tats.Contr�leurBoutonArr�ter;
import �tats.Contr�leurBoutonLancer;
import �tats.Contr�leurCliqueEnfonc�;
import �tats.Contr�leurCliqueRelach�;
import �tats.Contr�leur�tat;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContr�l�e extends Application implements MouseInputListener, ActionListener {
	protected Contr�leur�tat contr�leurBoutonCourant;
	protected Contr�leur�tat contr�leurCliqueCourant;
	protected Contr�leurCliqueEnfonc� contr�leurCliqueEnfonc�;
	protected Contr�leurCliqueRelach� contr�leurCliqueRelach�;
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
		installeContr�leurs(cadreAngryBalls);
	}
	
	/*
	 * construit le graphe orient� correspondant au diagramme de transition d'�tats.
	 * Rappelons que chaque �tat est g�r� par un contr�leur d'�tat. Il faut donc
	 * autant de contr�leurs que d'�tats + le contr�leur courant
	 */
	private void installeContr�leurs(CadreAngryBalls cadreAngryBalls) {
		this.contr�leurCliqueEnfonc� = new Contr�leurCliqueEnfonc�(this);
		this.contr�leurCliqueRelach� = new Contr�leurCliqueRelach�(this, contr�leurCliqueEnfonc�, contr�leurCliqueEnfonc�);
		this.contr�leurCliqueEnfonc�.setSuivant(contr�leurCliqueRelach�);
		this.contr�leurCliqueEnfonc�.setRetour(contr�leurCliqueRelach�);
		this.setContr�leurCliqueCourant(contr�leurCliqueEnfonc�);
		
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
	
	@Override
	public void mousePressed(MouseEvent e) {
		this.setChanged();
		this.notifyObservers(e);
		this.contr�leurCliqueCourant.actionD�tect�e(e);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.setChanged();
		this.notifyObservers(e);
		this.contr�leurCliqueCourant.actionD�tect�e(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// this.controleurCourant.actionD�tect�e(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.contr�leurBoutonCourant.actionD�tect�e(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println("Mouse moved");
		
	}
}
