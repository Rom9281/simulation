package tp.model.agents;

import java.awt.Point;
import java.util.HashSet;

import hebergeurs.Hebergeur;

/**
 * Classe qui modélise l'objet du décor arbre
 * Elle peut acceuillir les frelons.*/
public class Arbre extends Vegetal implements Hebergeur{
	
	protected Point coord; // Coordonnés de la ruche
	protected HashSet population; // création de la variable contenat la population
	protected int populationMax; // Int definissant le nombre d'habitant max
	

	public Arbre(Point coord) {
		super(coord); // Appel du constructeur de décor
	}

	public Arbre() {
		this(new Point(0,0)); // Appel d'un autre constructeur de Arbre.
	}
	
	/** Verifie si l'animal est un frelon */
	public boolean peutAcceuillir(Animal animal) { 
		if(this.getClass().getSimpleName() == "Frelon") { // A voir avec le professeur!! Assez peu efficace (trop de types d'abeilles)...
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Permet d'ajouter un hebergé
	 * Si la population n'est pas au maximum
	 * Si l'animal est un frelon*/
	public boolean acceuillir(Animal animal) { // TODO : Il faut gerer les cas ou la population est trop grande.
		
		if(this.peutAcceuillir(animal)){ // Verifier que l'animal est un frelon
			
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
