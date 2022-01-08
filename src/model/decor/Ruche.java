package model.decor;

import java.awt.Point;
import java.util.LinkedHashSet;
import java.util.Set;
import model.agents.Animal;
import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	private Set<AbeilleDomestique> population; // creation du hashlist de la population d'abeilles
	
	/**
	 * constante taille maximale de la ruche
	 */
	private static int populationMax = 1000;
	
	/**
	 * Constructeur
	 * */
	public Ruche(Point p) {
		super(p);
		population = new LinkedHashSet<AbeilleDomestique>(); // Initialisation de population
	}

	
	/**
	 * Methode permetant de savoir si peut acceuillir:
	 	* Si l'animal est une abeille domestique
	 	* Si la population est inferieur a la population max
	 	* Si elle ne contient deja pas cet abeille 	
	 */
	public boolean peutAccueillir(Animal a){
		if(a instanceof AbeilleDomestique){ // Si l'animal est une abeille domestique
			if(population.size()<populationMax){ // si la population est inferieur au maximum
				if(!(population.contains(a))){ // si elle n'est pas deja dans la ruche
					return true; // peut acceuillir
				}
			}
		} 
		return false; // sinon non
	}

	
	/**
	 * Methode permetant d'acceuillir une abeille domestique
	 * */
	public boolean accueillir(Animal a) {
		
		boolean ret = false;
		
		if(peutAccueillir(a)) { // On verifie que la ruche peut acceuillir
			
			/* Ne pas faire ça ici: c'est à l'animal de mettre à jour ses attributs
			 * a.setHebergeur(this);
			 */
			
			population.add(((AbeilleDomestique) a)); // ajoute l'abeille domestique a la ruche
			
			ret=true;
		}
		return ret;
	}
	
	/**
	 * Permet de faire l'affichage
	 */
	public String toString() {
		/*
		 * "\t" code une tabulation dans une chaine de caractères
		 * "\n" un saut de ligne 
		 */
		
		String ret =""; // String a retourner
		
		ret = ret + String.format("Ruche (%f;%f) : population %s abeilles\n",this.getCoord().getX(),this.getCoord().getY(),population.size()); // Impression des informations de la ruche
		for(AbeilleDomestique membre:population) {
			ret = ret + String.format("\t*AbeilleDomestique %d : (%f,%f), %s\n",membre.getId(),membre.getCoord().getX(),membre.getCoord().getY(),membre.getSexe()); // impression des informations de chaque 
		}
		return ret;
	}
	
	/**
	 * Permet de supprimer l'habitant d'une liste
	 * */
	public boolean supprimer(Animal mort) {
		boolean ret = false;
		// TODO: verifier le type
		if(population.contains(mort)) { // Si le mort fait bien partie de la population
			this.population.remove(mort); // Enlever le mort
			ret = true; // valider la transaction
		}
			
		return ret;
	}
	
	/**
	 * Main pour tester
	 * TODO : A SUPRIMER!
	 * */
	/*
	public static void main(String[] a) {
		Ruche r = new Ruche(new Point(0,0));
		r.accueillir(new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r));
		System.out.println(r);
		r.accueillir(new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r));
		System.out.println(r);
		r.accueillir(new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r));
		System.out.println(r);
	}
	*/
}
