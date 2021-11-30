package tp.model.agents;

import java.awt.Point;
import java.util.HashSet;
import hebergeurs.Hebergeur;


public class Ruche extends Decor implements Hebergeur{
	
	protected Point coord; // Coordonnés de la ruche
	protected HashSet population; // création de la variable contenat la population
	protected int populationMax; // Int definissant le nombre d'habitant max
	
	public Ruche(Point point) {
		super(point); // Appel du constructeur de décor
	}
	
	public Ruche() {
		this(new Point(0,0)); // appel d'un autre constructeur
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
			
			if(this.population.size() == this.populationMax){ // Si la population est égal à la taille maximale
				
				this.population.add(animal.hashCode()); // Ajouter le hash de l'animal au bail
				return true; // valider la demarche		
				
			}
			
			else {
				return false; // Refus d'ajouter
			}
		}
		else {
			return false; // Refus d'ajouter
		}
	}
	
}
