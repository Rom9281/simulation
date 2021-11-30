package heberges;

import tp.model.agents.Animal;

/**
 * Interface pour animaux hebergés
 * Elle est moins forte que l'interface hebergeur */
public interface Heberge {
	public abstract boolean peutHabiter(Animal animal);
	public abstract boolean habiter(Animal animal); 
}
