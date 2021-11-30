package tp.model.agents;

import java.awt.Point;

import heberges.Heberge;
import hebergeurs.Hebergeur;
import java.util.HashSet;



public class Abeille extends Animal implements Hebergeur,Heberge{
	/*
	 * Variables
	 * */
	
	private boolean parasite = false;
	protected HashSet population; // création de la variable contenat la population
	
	/*
	 * Constructeurs
	 * */
	
	public Abeille(Sexe sexe, Point coord) {
		super(sexe, new Point(coord)); // appel le constructeur d'animal
	}

	public Abeille(Sexe sexe) {
		this(sexe, new Point(0,0)); // A
	}

	public Abeille() {
		this(Sexe.Male,new Point(0,0));
	}
	
	/*
	 * Methodes
	 * */
	
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
	
	/**
	 * Utilisé pour specifier qui est hebergé*/
	public boolean peutHabiter(Decor decor){
		return true;
	}
	
	public boolean habiter(Decor decor){
		return true;
	}
}
