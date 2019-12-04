package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import modele.Bille;
import vues.Application;
import vues.CadreAngryBalls;
import états.ContrôleurBoutonArrêter;
import états.ContrôleurBoutonLancer;
import états.ContrôleurCliqueEnfoncé;
import états.ContrôleurCliqueRelaché;
import états.ContrôleurÉtat;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContrôlée extends Application implements MouseListener, ActionListener {
	protected ContrôleurÉtat contrôleurBoutonCourant;
	protected ContrôleurÉtat contrôleurCliqueCourant;
	ContrôleurCliqueEnfoncé contrôleurCliqueEnfoncé;
	ContrôleurCliqueRelaché contrôleurCliqueRelaché;
	ContrôleurBoutonLancer contrôleurBoutonLancer;
	ContrôleurBoutonArrêter contrôleurBoutonArrêter;
	AnimationBilles animationBilles;

	public ApplicationContrôlée(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		this.animationBilles = animationBilles;
		cadreAngryBalls.billard.addMouseListener(this);
		cadreAngryBalls.lancerBilles.addActionListener(this);
		cadreAngryBalls.arrêterBilles.addActionListener(this);
		installeContrôleurs(cadreAngryBalls);
	}

	/*
	 * construit le graphe orienté correspondant au diagramme de transition d'états.
	 * Rappelons que chaque état est géré par un contrôleur d'état. Il faut donc
	 * autant de contrôleurs que d'états + le contrôleur courant
	 */
	private void installeContrôleurs(CadreAngryBalls cadreAngryBalls) {
		
		
		this.contrôleurCliqueEnfoncé = new ContrôleurCliqueEnfoncé(this);
		this.contrôleurCliqueRelaché = new ContrôleurCliqueRelaché(this, contrôleurCliqueEnfoncé, contrôleurCliqueEnfoncé);
		this.contrôleurCliqueEnfoncé.setSuivant(contrôleurCliqueRelaché);
		this.contrôleurCliqueEnfoncé.setRetour(contrôleurCliqueRelaché);
		this.setContrôleurCliqueCourant(contrôleurCliqueEnfoncé);
		
		
		
		this.contrôleurBoutonLancer = new ContrôleurBoutonLancer(cadreAngryBalls.lancerBilles, this.animationBilles, this);
		this.contrôleurBoutonArrêter = new ContrôleurBoutonArrêter(cadreAngryBalls.arrêterBilles, this.animationBilles, this, contrôleurBoutonLancer, contrôleurBoutonLancer);
		this.contrôleurBoutonLancer.setSuivant(this.contrôleurBoutonArrêter);
		this.contrôleurBoutonLancer.setRetour(this.contrôleurBoutonArrêter);
		this.setContrôleurBoutonCourant(contrôleurBoutonLancer);
	}
	
	public ContrôleurÉtat getContrôleurBoutonCourant() {
		return contrôleurBoutonCourant;
	}

	public void setContrôleurBoutonCourant(ContrôleurÉtat contrôleurBoutonCourant) {
		this.contrôleurBoutonCourant = contrôleurBoutonCourant;
	}

	public ContrôleurÉtat getContrôleurCliqueCourant() {
		return contrôleurCliqueCourant;
	}

	public void setContrôleurCliqueCourant(ContrôleurÉtat contrôleurCliqueCourant) {
		this.contrôleurCliqueCourant = contrôleurCliqueCourant;
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		this.contrôleurCliqueCourant.actionDétectée(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.contrôleurCliqueCourant.actionDétectée(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// this.controleurCourant.actionDétectée(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.contrôleurBoutonCourant.actionDétectée(e);
	}
}
