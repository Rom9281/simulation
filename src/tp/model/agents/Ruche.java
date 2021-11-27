package tp.model.agents;

import java.awt.Point;
import java.util.HashSet;
import hebergeurs.Hebergeur;


public class Ruche extends Decor implements Hebergeur{
	
	protected Point coord; // Coordonnés de la ruche
	protected HashSet population; // création de la variable contenat la population
	protected int populationMax; // Int definissant le nombre d'habitant max
	
	public Ruche(Point point) {
		super();
		this.coord = new Point(point);
	}
	
	public Ruche() {
		this(new Point(0,0));
	}
	
	public boolean peutAcceuillir(Animal animal) {
		if(this.getClass().getSimpleName() == "Abeille") { // A voir avec le professeur!! Assez peu efficace (trop de types d'abeilles)...
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean acceuillir(Animal animal) { // TODO : Il faut gerer les cas ou la population est trop grande.
		if(this.peutAcceuillir(animal)){
			return true; // valider la demarche		
		}
		else {
			return false;
		}
	}
	
}
