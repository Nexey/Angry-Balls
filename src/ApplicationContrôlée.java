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
import �tats.Contr�leurCliqueEnfonc�;
import �tats.Contr�leurCliqueRelach�;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContr�l�e extends Application implements MouseListener, ActionListener {
	Contr�leurCliqueEnfonc� contr�leurCliqueEnfonc�;
	Contr�leurCliqueRelach� contr�leurCliqueRelach�;

	public ApplicationContr�l�e(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		cadreAngryBalls.billard.addMouseListener(this);
		cadreAngryBalls.lancerBilles.addMouseListener(this);
		cadreAngryBalls.arr�terBilles.addMouseListener(this);
		installeContr�leurs();
	}

	/*
	 * construit le graphe orient� correspondant au diagramme de transition d'�tats.
	 * Rappelons que chaque �tat est g�r� par un contr�leur d'�tat. Il faut donc
	 * autant de contr�leurs que d'�tats + le contr�leur courant
	 */
	private void installeContr�leurs() {
		this.contr�leurCliqueEnfonc� = new Contr�leurCliqueEnfonc�(this);
		this.contr�leurCliqueRelach� = new Contr�leurCliqueRelach�(this, contr�leurCliqueEnfonc�, contr�leurCliqueEnfonc�);
		this.contr�leurCliqueEnfonc�.setSuivant(contr�leurCliqueRelach�);
		this.contr�leurCliqueEnfonc�.setRetour(contr�leurCliqueRelach�);
		this.controleurCourant = contr�leurCliqueEnfonc�;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		this.controleurCourant.actionD�tect�e(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.controleurCourant.actionD�tect�e(e);
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
