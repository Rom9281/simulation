package hebergeurs;

import tp.model.agents.Animal;

public interface Hebergeur {
	
	public abstract boolean peutAcceuillir(Animal animal);
	public abstract boolean acceuillir(Animal animal);
	
	
}
