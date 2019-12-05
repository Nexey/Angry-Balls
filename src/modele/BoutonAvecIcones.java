package modele;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// Gère une liste d'icônes
@SuppressWarnings("serial")
public class BoutonAvecIcones extends JButton {
	Map<String, ImageIcon> listeIcone;

	public BoutonAvecIcones() {
		this.listeIcone = new HashMap<String, ImageIcon>();
	}
	
	public BoutonAvecIcones(Map<String, ImageIcon> listeIcone) {
		this.listeIcone = listeIcone;
	}

	public Map<String, ImageIcon> getListeIcone() {
		return listeIcone;
	}

	public void setListeIcone(Map<String, ImageIcon> listeIcone) {
		this.listeIcone = listeIcone;
	}
	
	public Map<String, ImageIcon> addIcone(String nom, ImageIcon icone) {
		this.listeIcone.put(nom, icone);
		return this.listeIcone;
	}
	
	public ImageIcon getIcone(String nom) {
		return this.listeIcone.get(nom);
	}
}
