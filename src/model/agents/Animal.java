package model.agents;

import java.awt.Point;
import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import model.comportements.Deplacable;
import model.comportements.Hebergeur;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
/* 
 * abstract à partir du TP2 + déplacement des méthodes/attributs du TP1 concernant les agents dans la classe agent:
 * attributs de classe 
	private static int currentId = 0;
	
	attributs d'instance:
	private int id;
	protected int age;
	protected PointPositif coord; //question subsdiaire du tp2 + solution présentée au cours 4
	//protected Point coord;
	 
	méthodes:
	public Agent(Point coord)
	public Agent()
	
	equals, hascode,tostring (sans le sexe)
	getCoord, setAge, vieillir
	
	getUniqueId
	
	Attention: rencontrer(Agent a) devient abstrait 
 */


public abstract class Animal extends Agent implements Deplacable {
	/*
	 * SeDeplacer: soit abstract, soit encore mieux faire une interface Deplacable
	 */
	
	/** état de santé de l'animal */
	private Etat etat=Etat.Normal;
	/** sexe de l'animal */
	private Sexe sexe;
	/** hebergeur de l'animal */
	protected Hebergeur hebergeur = null;
	
	/** 
	 * constructeurs 
	 */
	public Animal(Sexe sexe, Point p) {
		super(p);
		this.sexe=sexe;
	}
	
	public Animal(Sexe sexe) {
		this(sexe,new Point(0,0));
	}
	
	public Animal() {
		this(Sexe.Femelle);
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	
	public Sexe getSexe() {
		return sexe;
	}
	
	public Etat getNiveauSante() {return etat;}
	/**
	 * protected, car seul l'animal doit pouvoir changer son niveau de santé
	 * @return
	 */
	protected void setNiveauSante(Etat e) {etat = e;}
	
	public String toString() {
		//bien penser à réutiliser l'existant de Agent avec le super.toString()
		return super.toString()+", "+sexe;
	}
	
	/**
	 * déplacement aléatoire avec -1<=dx<=1 et  -1<=dy<=1
	 * @see model.comportements.Deplacable#seDeplacer()
	 */
	public void seDeplacer() {
		int aleaX = (int)(Math.random()*3)-1;
		int aleaY = (int)(Math.random()*3)-1;
		this.setCoord((int)(coord.getX()+aleaX),(int)(coord.getY()+aleaY));
	}
	
	/**
	 * Permet a l'animal de s'installer qqpart
	 * */
	protected final boolean sInstaller(Hebergeur h) {
		boolean ret=false;
		
		if(h!= null && h.accueillir(this)) {
			hebergeur = h;
			ret=true;
		}
		return ret;
	}
	
	/**
	 * Agrave l'etat de l'animal
	 * */
	protected final void aggraverEtat() {
		/*Etat[] tableauEtat = Etat.values();
		List<Etat> listeEtat = Arrays.asList(tableauEtat);
		//LinkedList<Etat> liste = new LinkedList<Etat>(listeEtat);
		
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		 
		Iterator<Etat> it = liste.listIterator(); // creation de l'iterateur
		
		boolean trouve = false;
		while(it.hasNext() && !trouve) {
			if(it.next().equals(this.etat)) {
				trouve=true;
				}
			}
		*/
		
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values())); // creation d'une liste chainé a partir de la collection du type état, que l'on a transformé en array.
		ListIterator<Etat> it = liste.listIterator(liste.indexOf(etat)); // création de l'itérateur de liste it
		if(it.hasNext()) {etat = it.next();}	//si jamais on a un état suivant, passer a l'etat suivant
	}
	
	/**
	 * Ameliore l'état de l'animal
	 */
	protected final void ameliorerEtat() {
		
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values())); // idem aggraver
		ListIterator<Etat> it = liste.listIterator(liste.indexOf(etat)); //creation de l'it de liste
		if(it.hasPrevious()) {etat = it.previous();} //si jamais on a un état suivant, passer a l'etat suivant
	}
	
	public void setHebergeur(Hebergeur hebergeur){
		this.hebergeur = hebergeur;
	}
	
	/**
	 * Permet de faire mourrir son animal
	 * */
	public boolean mourrir() {
		boolean ret = false;
		
		if(this.hebergeur != null){
			ret = this.hebergeur.supprimer(this);// Si on arrive a le supprimer de la liste de son hebergeur, valider
		}
		return ret;
	}

}
