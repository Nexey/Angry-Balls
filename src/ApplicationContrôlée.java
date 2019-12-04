import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;
import modele.Bille;
import vues.Application;
import vues.CadreAngryBalls;
import états.ContrôleurCliqueEnfoncé;
import états.ContrôleurCliqueRelaché;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContrôlée extends Application implements MouseListener, ActionListener {
	ContrôleurCliqueEnfoncé contrôleurCliqueEnfoncé;
	ContrôleurCliqueRelaché contrôleurCliqueRelaché;

	public ApplicationContrôlée(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		cadreAngryBalls.billard.addMouseListener(this);
		cadreAngryBalls.lancerBilles.addMouseListener(this);
		cadreAngryBalls.arrêterBilles.addMouseListener(this);
		installeContrôleurs();
	}

	/*
	 * construit le graphe orienté correspondant au diagramme de transition d'états.
	 * Rappelons que chaque état est géré par un contrôleur d'état. Il faut donc
	 * autant de contrôleurs que d'états + le contrôleur courant
	 */
	private void installeContrôleurs() {
		this.contrôleurCliqueEnfoncé = new ContrôleurCliqueEnfoncé(this);
		this.contrôleurCliqueRelaché = new ContrôleurCliqueRelaché(this, contrôleurCliqueEnfoncé, contrôleurCliqueEnfoncé);
		this.contrôleurCliqueEnfoncé.setSuivant(contrôleurCliqueRelaché);
		this.contrôleurCliqueEnfoncé.setRetour(contrôleurCliqueRelaché);
		this.controleurCourant = contrôleurCliqueEnfoncé;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.controleurCourant.actionDétectée(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.controleurCourant.actionDétectée(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
