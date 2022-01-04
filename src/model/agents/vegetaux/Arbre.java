package model.agents.vegetaux;

import java.awt.Point;
import java.util.LinkedHashSet;
import java.util.Set;

import model.agents.Animal;
import model.agents.animaux.AbeilleDomestique;
import model.agents.animaux.AbeilleSolitaire;
import model.agents.animaux.Frelon;
import model.comportements.Hebergeur;

public class Arbre extends Vegetal implements Hebergeur{
	/**
	 * Variables
	 * */
	private double taille = 1.0;
	private Set<Animal> population; // creation du hashlist de la population d'abeilles
	
	
	/**
	 * Constructeur
	 * */
	public Arbre(Point point, double taille) {
		super(point); 
		this.taille=taille;
		population = new LinkedHashSet<Animal>();
	}

	@Override
	public boolean peutAccueillir(Animal a) {
		return (a instanceof AbeilleSolitaire || a instanceof Frelon)&&population.size()<getMaxHeberges();
	}

	private int getMaxHeberges() {
		return (int)(Math.pow(taille,2));
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		
		if(peutAccueillir(a)) {// Si peut acceuillir, acceuillir
			population.add(a); // ajouter a
			ret=true;
		}
		return ret;
	}
	
	public boolean supprimer(Animal mort) {
		boolean ret = false;
		if(population.contains(mort)){
			ret = true;
		}
		return ret;
	}

	@Override
	public void produire() {
		qteNectar += Math.pow(2, taille);		
	}

}
