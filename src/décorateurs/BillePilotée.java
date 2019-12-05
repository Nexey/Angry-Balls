package d�corateurs;

import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;
import modele.Bille;

public class BillePilot�e extends D�corateurBille implements Observer {

	public BillePilot�e(Bille billeD�cor�e) {
		super(billeD�cor�e);
	}

	@Override
	public void update(Observable o, Object arg) {
		MouseEvent event;
		if (arg instanceof MouseEvent) {
			event = (MouseEvent) arg;
			
			Vecteur pos = new Vecteur(event.getX(), event.getY());
			if (Geop.appartientDisque(pos, this.getPosition(), this.getRayon())) {
				System.out.println("touch�");
			}
		}
	}

}
