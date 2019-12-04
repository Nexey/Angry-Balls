import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import modele.Bille;
import vues.Application;
import vues.CadreAngryBalls;

/* Cette classe se charge de rajouter les observeurs sur l'application */

public class ApplicationContrôlée extends Application implements KeyListener {

	public ApplicationContrôlée(Vector<Bille> billes, AnimationBilles animationBilles, CadreAngryBalls cadreAngryBalls) {
		super(billes);
		cadreAngryBalls.addKeyListener(this);
		cadreAngryBalls.billard.addKeyListener(this);
	}
	
	@Override
    public void keyPressed(KeyEvent e) {
		System.out.println("clic");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("clic");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("clic");
		
	}
}
