package heberges;

import hebergeurs.Hebergeur;
import tp.model.agents.Animal;
import tp.model.agents.Decor;

/**
 * Interface pour animaux hebergés
 * Elle est moins forte que l'interface hebergeur */

public interface Heberge {
	
	public abstract boolean habiter(Hebergeur hebergeur);
	
}
