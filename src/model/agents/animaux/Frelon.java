package model.agents.animaux;

import java.awt.Point;
import java.util.ArrayList;

import model.agents.Agent;
import model.agents.Animal;
import model.agents.Sexe;

public abstract class Frelon extends Animal {
	/**
	 * list d'objets de type "Class"
	 * Ces types Class sont paramétrés par <? extends Animal>
	 * Cela signifie que la classe représentée par Class doit hériter de la classe Animal
	 */
	protected ArrayList<Class<? extends Animal>> proies;
	
	public Frelon(Sexe s,Point p) {
		super(s,p);
		
		proies = new ArrayList<Class<? extends Animal>>(); // creation de la liste de classes acceptables
		proies.add(AbeilleDomestique.class); // Ajout des abeilles domestiques à cette array de objets de classe classe
		proies.add(AbeilleSolitaire.class);  //
		
		
		
		/*
		 * TODO: ajouter l'objet Class qui représente la classe Abeille à la liste proie
		 */
	}
	
	@Override
	public void rencontrer(Agent a) {
		try {
			gestionProie((Animal)a);
		}
		catch (ClassCastException cce) {
			System.err.println(a+" n'est pas un Animal");
		}
		
	}
	
	protected void gestionProie(Animal proie_pot) {
		/**
		 * Gere la relation du frelon avec sa proie
		 * */
		
		if(faim && (proies.contains(proie_pot.getClass()))) { // Si le frelon a faim et que sa liste de proie contient le type de l'animal
			faim=false; // Le frelon n'as plus faim
			// TODO : developper un peu plus cet aspect...(niveau de vie...)
		}
	}
	
	@Override
	protected void maj() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
	
}
