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
		cadreAngryBalls.boutonJeu.setFocusPainted(false);
		cadreAngryBalls.boutonJeu.setBorderPainted(false);
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
	
	public Vecteur getCoordsMouseEvent(MouseEvent e) {
		return new Vecteur(e.getX(), e.getY());
	}
	
	protected void posHandler(InfoClique clique) {
		this.setChanged();
		this.notifyObservers(clique);
		this.contrôleurCliqueCourant.actionDétectée(clique);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		InfoClique infoClique = new InfoClique(InfoClique.PRESSE_INITIALE, this.getCoordsMouseEvent(e));
		this.posHandler(infoClique);
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		InfoClique infoClique = new InfoClique(InfoClique.RELACHÉ, this.getCoordsMouseEvent(e));
		this.posHandler(infoClique);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		InfoClique infoClique = new InfoClique(InfoClique.PRESSÉ_BOUGEANT, this.getCoordsMouseEvent(e));
		this.posHandler(infoClique);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.contrôleurBoutonCourant.actionDétectée(e);
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
