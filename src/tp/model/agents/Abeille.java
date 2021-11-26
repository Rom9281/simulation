package tp.model.agents;

import java.awt.Point;
import hebergeurs.Hebergeur;

public class Abeille extends Animal implements Hebergeur{
	private boolean peutAcceuillir = true; // En capacité d'acceuillir
	private Animal parasite;

	public Abeille(Sexe sexe, Point coord) {
		super(sexe, coord);
		// TODO Auto-generated constructor stub
	}

	public Abeille(Sexe sexe) {
		super(sexe);
		// TODO Auto-generated constructor stub
	}

	public Abeille() {
		// TODO Auto-generated constructor stub
	}
	
	/** Verifie si l'animal est un varroa */
	public boolean peutAcceuillir(Animal animal) {
		if(this.getClass().getSimpleName() == "Varroa") { // Si l'animal est un varroa
			return true; // valider la possibilité d'acceuil
		}
		else {
			return false; // sinon non
		}
	}
	/** Permet l'acceuil du parasite */
	public boolean acceuillir(Animal animal) {
		if(this.peutAcceuillir(animal)){
			if(peutAcceuillir) { // Si l'animal est un varroa
				parasite = animal; // le prendre
				peutAcceuillir = false; // changer le statut en non-acceuilleur
				return true; // valider la demarche
			}
			else {
				return false; // signaler l'echec de la fonction
			}		
		}
		else {
			return false;
		}
	}	
	
}
