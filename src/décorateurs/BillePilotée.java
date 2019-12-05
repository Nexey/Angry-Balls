package décorateurs;

import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public class BillePilotée extends DécorateurBille implements Observer {

	public BillePilotée(Bille billeDécorée) {
		super(billeDécorée);
	}

	@Override
	public void update(Observable o, Object arg) {
		MouseEvent event;
		if (arg instanceof MouseEvent) {
			event = (MouseEvent) arg;
			
			Vecteur pos = new Vecteur(event.getX(), event.getY());
			if (Geop.appartientDisque(pos, this.getPosition(), this.getRayon())) {
				System.out.println("touché");
			}
		}
	}

}
