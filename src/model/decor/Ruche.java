package model.decor;

import java.awt.Point;
import java.util.LinkedHashSet;
import java.util.Set;
import model.agents.Animal;
import model.agents.animaux.AbeilleDomestique;
import model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	private Set<AbeilleDomestique> population = new LinkedHashSet<AbeilleDomestique>();// creation du hashlist de la population d'abeilles
	
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
		/**
		 * Methode permetant d'acceuillir une abeille domestique
		 * */
		
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
	
	public String toString() {
		/**
		 * Permet de faire l'affichage
		 */
		
		String ret ="";
		ret = ret + String.format("Ruche (%d;%d) : population %s abeilles",this.getCoord().getX(),this.getCoord().getY(),population.size()); // Impression des informations de la ruche
		for(AbeilleDomestique membre:population) {
			ret = ret + String.format("\t*AbeilleDomestique %i : (%d,%d), %s\n",membre.getId(),membre.getCoord().getX(),membre.getCoord().getY(),membre.getSexe()); // impression des informations de chaque 
		}
		
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
