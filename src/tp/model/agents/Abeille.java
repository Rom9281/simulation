package tp.model.agents;

import java.awt.Point;
import hebergeurs.Hebergeur;


public class Abeille extends Animal implements Hebergeur{
	private boolean parasite = false;

	public Abeille(Sexe sexe, Point coord) {
		super(sexe, new Point(coord));
		// TODO Auto-generated constructor stub
	}

	public Abeille(Sexe sexe) {
		this(sexe, new Point(0,0));
	}

	public Abeille() {
		this(Sexe.Male,new Point(0,0));
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
			if(!(this.parasite)) { // Si l'animal est un varroa
				this.parasite = true; // le prendre
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
