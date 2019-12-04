package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import modele.Bille;
import vues.Application;
import vues.CadreAngryBalls;
import �tats.Contr�leurBoutonArr�ter;
import �tats.Contr�leurBoutonLancer;
import �tats.Contr�leurCliqueEnfonc�;
import �tats.Contr�leurCliqueRelach�;
import �tats.Contr�leur�tat;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContr�l�e extends Application implements MouseListener, ActionListener {
	protected Contr�leur�tat contr�leurBoutonCourant;
	protected Contr�leur�tat contr�leurCliqueCourant;
	Contr�leurCliqueEnfonc� contr�leurCliqueEnfonc�;
	Contr�leurCliqueRelach� contr�leurCliqueRelach�;
	Contr�leurBoutonLancer contr�leurBoutonLancer;
	Contr�leurBoutonArr�ter contr�leurBoutonArr�ter;
	AnimationBilles animationBilles;

	public ApplicationContr�l�e(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		this.animationBilles = animationBilles;
		cadreAngryBalls.billard.addMouseListener(this);
		cadreAngryBalls.lancerBilles.addActionListener(this);
		cadreAngryBalls.arr�terBilles.addActionListener(this);
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
		
		
		
		this.contr�leurBoutonLancer = new Contr�leurBoutonLancer(cadreAngryBalls.lancerBilles, this.animationBilles, this);
		this.contr�leurBoutonArr�ter = new Contr�leurBoutonArr�ter(cadreAngryBalls.arr�terBilles, this.animationBilles, this, contr�leurBoutonLancer, contr�leurBoutonLancer);
		this.contr�leurBoutonLancer.setSuivant(this.contr�leurBoutonArr�ter);
		this.contr�leurBoutonLancer.setRetour(this.contr�leurBoutonArr�ter);
		this.setContr�leurBoutonCourant(contr�leurBoutonLancer);
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
		this.contr�leurCliqueCourant.actionD�tect�e(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
}
