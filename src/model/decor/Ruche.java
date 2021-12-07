package model.decor;

import java.awt.Point;
import java.util.HashSet;
import model.agents.Animal;
import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	private HashSet<Class<AbeilleDomestique>> population = new HashSet<Class<AbeilleDomestique>>();// creation du hashlist de la population d'abeilles
	
	/**
	 * constante taille maximale de la ruche
	 */
	private static int populationMax = 1000;
	
	public Ruche(Point p) {
		super(p);
		//population = new ... TODO;
	}

	@Override
	public boolean peutAccueillir(Animal a){
		/**
		 * Methode permetant de savoir si peut acceuillir:
		 	* Si l'animal est une abeille domestique
		 	* Si la population est inferieur a la population max
		 	* Si elle ne contient deja pas cet abeille 	
		 */
		
		if(a instanceof AbeilleDomestique){ // Si l'animal est une abeille domestique
			if(population.size()<populationMax){ // si la population est inferieur au maximum
				if(!(population.contains(a))){ // si elle n'est pas deja dans la ruche
					return true; // peut acceuillir
				}
			}
		} 
		return false; // sinon non
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			/* Ne pas faire ça ici: c'est à l'animal de mettre à jour ses attributs
			 * a.setHebergeur(this);
			 */
			//TODO ajouter a à la population
			ret=true;
		}
		return ret;
	}
	
	public String toString() {
		String ret ="TODO";
		/*
		 * "\t" code une tabulation dans une chaine de caractères
		 * "\n" un saut de ligne 
		 */
		return ret;
	}
	
	public static void main(String[] a) {
		/*
		Ruche r = new Ruche(new Point(0,0));
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r);
		System.out.println(r);
		*/
	}
}
