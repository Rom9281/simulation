package tp.model.agents;
import java.awt.Point;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
public class Animal extends Agent {
	/** état de santé de l'animal */
	private Etat etat; // On initialise l'animal =Etat.<valeur> a chaque animal sp�cifique
	private Sexe sexe;

	/* 
	 * constructeurs 
	 */


	public Animal(Sexe sexe, Point coord) {
		super(new Point(coord));
		this.age = 0; // Modification de l'age:  pas de modification directement
		// Utilit� d�pend du cahier des charges

		this.id = Animal.getUniqueId(); // recuperation de l'id

		this.sexe=sexe; // On definit le sexe de l'objet
	}

	public Animal(Sexe sexe) {
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(sexe, new Point(0,0)); // Appel de constructeur posse

	}

	public Animal() {
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Femelle,new Point(0,0)); 
	}

	/*
	 *  Accesseurs et mutateurs
	 */
	//TODO

	public Sexe getSexe() {
		return sexe;
	}

	/*
	 * Redéfinitions de méthodes d'object
	 */
	//TODO
	public String toString() {
		return super.toString()+" "+sexe;
	}

	/* 
	 * comportements d'instance
	 */
	
	public void seDeplacer() {

		double dx = 3*Math.random() - 1.5; // ajout de x
		double dy = 3*Math.random() - 1.5; // ajout de y

		this.coord.move((int) (coord.getX()+dx),(int) (coord.getX()+dy)); // modification des coordonn�s
	}



	/* comportements de classe */ 
	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	private static int getUniqueId() {
		currentId++;
		return currentId;
	}
}
	
