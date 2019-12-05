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
import états.ContrôleurBoutonArrêter;
import états.ContrôleurBoutonLancer;
import états.ContrôleurCliqueEnfoncé;
import états.ContrôleurCliqueRelaché;
import états.ContrôleurÉtat;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContrôlée extends Application implements MouseInputListener, ActionListener {
	protected ContrôleurÉtat contrôleurBoutonCourant;
	protected ContrôleurÉtat contrôleurCliqueCourant;
	protected ContrôleurCliqueEnfoncé contrôleurCliqueEnfoncé;
	protected ContrôleurCliqueRelaché contrôleurCliqueRelaché;
	protected ContrôleurBoutonLancer contrôleurBoutonLancer;
	protected ContrôleurBoutonArrêter contrôleurBoutonArrêter;
	protected AnimationBilles animationBilles;
	protected boolean jeuLancé;
	

	public ApplicationContrôlée(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		this.animationBilles = animationBilles;
		this.jeuLancé = false;
		cadreAngryBalls.billard.addMouseListener(this);
		cadreAngryBalls.billard.addMouseMotionListener(this);
		cadreAngryBalls.boutonJeu.addActionListener(this);

		cadreAngryBalls.boutonJeu.addIcone("Lancer", new ImageIcon("src/assets/lancer.png"));
		cadreAngryBalls.boutonJeu.addIcone("Arrêter", new ImageIcon("src/assets/pause.png"));
		cadreAngryBalls.boutonJeu.setIcon(cadreAngryBalls.boutonJeu.getIcone("Lancer"));
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
		
		this.contrôleurBoutonLancer = new ContrôleurBoutonLancer(cadreAngryBalls.boutonJeu, this.animationBilles, this);
		this.contrôleurBoutonArrêter = new ContrôleurBoutonArrêter(cadreAngryBalls.boutonJeu, this.animationBilles, this, contrôleurBoutonLancer, contrôleurBoutonLancer);
		this.contrôleurBoutonLancer.setSuivant(this.contrôleurBoutonArrêter);
		this.contrôleurBoutonLancer.setRetour(this.contrôleurBoutonArrêter);
		this.setContrôleurBoutonCourant(contrôleurBoutonLancer);
	}

	public boolean isJeuLancé() {
		return jeuLancé;
	}

	public void setJeuLancé(boolean jeuLancé) {
		this.jeuLancé = jeuLancé;
	}
	
	public void majJeu() {
		this.jeuLancé = !this.jeuLancé;
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
		this.setChanged();
		this.notifyObservers(e);
		this.contrôleurCliqueCourant.actionDétectée(e);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		this.setChanged();
		this.notifyObservers(e);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Mouse dragged");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println("Mouse moved");
		
	}
}
