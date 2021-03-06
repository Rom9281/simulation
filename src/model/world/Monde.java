package model.world;

import java.awt.Point;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import model.agents.Agent;
import model.agents.Animal;
import model.agents.Etat;
import model.agents.Sexe;
import model.agents.animaux.Abeille;
import model.agents.animaux.AbeilleDomestique;
import model.agents.animaux.AbeilleSolitaire;
import model.agents.animaux.Frelon;
import model.agents.animaux.FrelonAsiatique;
import model.agents.animaux.FrelonEuropeen;
import model.agents.animaux.Varroa;
import model.agents.vegetaux.Arbre;
import model.agents.vegetaux.Fleur;
import model.decor.Ruche;

public class Monde {
	/**population d'agents dans le monde*/
	private Set<Agent>agents;
	
	/**map de probabilité pour trouver un agent*/
	private TreeMap<Agent,HashSet<Agent>> voisins_agent; 
	private static final Map<Integer,Agent> proba= Monde.probaAgent();
	
	/**constante: largeur du monde*/
	private static int LARGEUR = 30;
	
	/**constante: longueur du monde*/
	private static final float rayon = 10;
	private static int LONGUEUR = 20;
	
	/**Nombre de cycles*/
	private int cycles = 0;
	
	/**Durée d'un jour*/
	private final int duree_jour = 8;
	
	/**Mode nuit activé*/
	private boolean nuit = false;
	
	/**
	 * @param nbAgents
	 */
	public Monde(int nbAgents) {
		agents=generateAgents(nbAgents);
		voisins_agent = genererVoisinsAgents();
	}
	
	/**
	 * Méthode utilitaire statistique pour produire la table de proba
	 * d'apparition d'un agent
	 * @return
	 */
	private static Map<Integer, Agent> probaAgent() {
		Ruche r1 =new Ruche(new Point(10,50));
		Ruche r2 =new Ruche(new Point(100,20));
		Map<Integer,Agent> myMap = new LinkedHashMap<Integer,Agent>();
	    myMap.put(20,new AbeilleDomestique(Sexe.Assexue,new Point(0,0),r1));
	    myMap.put(40,new AbeilleDomestique(Sexe.Assexue,new Point(0,0),r2));
	    myMap.put(50,new AbeilleSolitaire(Sexe.Assexue,new Point(0,0)));
	    myMap.put(55,new FrelonEuropeen(Sexe.Assexue,new Point(0,0)));
	    myMap.put(60,new FrelonAsiatique(Sexe.Assexue,new Point(0,0)));
	    myMap.put(70,new Varroa(Sexe.Assexue,new Point(0,0)));
	    myMap.put(80,new Arbre(new Point(0,0),1.0));
	    myMap.put(85,new Arbre(new Point(0,0),2.0));
	    myMap.put(100,new Fleur(new Point(0,0)));
	    return myMap;
	}
	
	/**
	 * fabrication aléatoire d'un Agent par tirage dans la Map
	 * et positionnement aléatoire
	 * @param alea
	 * @return
	 */
	private static Agent tirage(int alea) {
		/*
		 * NE PAS TOUCHER!
		 */
		Agent agent=null;
		if(alea<100 && alea>=0) {
			boolean trouve = false;
			Iterator<Integer> it = proba.keySet().iterator();
			while(!trouve && it.hasNext()) {
				Integer clef = it.next();
				if(clef>=alea) {
					agent = proba.get(clef);
					trouve=true;
				}
			}
		}
		else {
			agent = new Fleur(new Point(0,0));
		}
		//positionnement aléatoire entre Longueur et Largeur
		int aleaX = (int)(Math.random()*LONGUEUR);
		int aleaY = (int)(Math.random()*LONGUEUR);
		agent.setCoord(aleaX, aleaY);
		return agent;
	}
	
	private TreeMap<Agent,HashSet<Agent>> genererVoisinsAgents(){
		TreeMap<Agent,HashSet<Agent>> tm = new TreeMap<Agent,HashSet<Agent>>();
		for(Agent particulier:agents) {
			tm.put(particulier,(HashSet<Agent>) gererRencontre(particulier));
		}
		return tm;
		
	}

	private TreeSet<Agent> generateAgents(int nbAgents) {
		TreeSet<Agent> ts = new TreeSet<Agent>();
		for(int i=0;i<nbAgents;i++) {
			int alea = (int)(Math.random()*100);
			//partie 2
			//ts.add((Agent)tirage(alea).clone());
			//partie 1
			ts.add(copieAgent(tirage(alea)));
		}
		return ts;
	}
	/**
	 * à supprimer dès la partie deux lorsqu'il devient possible de
	 * cloner les agents
	 * place toutes les abeilles dans la même ruche
	 * les arbres ont tous la même taille
	 * ne respecte pas les bonnes pratiques (switch case sur le type) 
	 * @param tirage
	 * @return
	 */
	private Agent copieAgent(Agent tirage) {
		// TODO Auto-generated method stub
		Ruche ruche =new Ruche(new Point(10,50));
		Agent ret = null;
		String classeAgentName = tirage.getClass().getSimpleName();
		switch(classeAgentName) {
			case "AbeilleDomestique":
				AbeilleDomestique ad = (AbeilleDomestique) tirage;
				ret = new AbeilleDomestique(ad.getSexe(),ad.getCoord(),ruche);
				break;
			case "AbeilleSolitaire":
				AbeilleSolitaire as = (AbeilleSolitaire) tirage;
				ret = new AbeilleSolitaire(as.getSexe(),as.getCoord());
				break;
			case "FrelonEuropeen":
				FrelonEuropeen fe = (FrelonEuropeen) tirage;
				ret = new FrelonEuropeen(fe.getSexe(),fe.getCoord());
				break;
			case "FrelonAsiatique":
				FrelonAsiatique fa = (FrelonAsiatique) tirage;
				ret = new FrelonAsiatique(fa.getSexe(),fa.getCoord());
				break;
			case "Varroa":
				Varroa v = (Varroa) tirage;
				ret = new Varroa(v.getSexe(),v.getCoord());
				break;
			case "Arbre":
				Arbre a = (Arbre) tirage;
				ret = new Arbre(a.getCoord(),1.0);
				break;
			default:
				Fleur f = (Fleur) tirage;
				ret = new Fleur(f.getCoord());
				break;
		}
		return ret;
	}

	public String toString() {
		String ret="";
		ret+="******************************\n";
		ret+="Le monde contient "+agents.size()+" agents:\n";
		
		Set<Agent> coordSet = new TreeSet<Agent>(new CoordComparator());//Appel la classe comparateur pour comparer les agents selon leur coordonnés
		coordSet.addAll(agents); // 
		
		for(Agent a:coordSet) {// on remplace agents->coordSet pour changer le mode de comparaison
			ret+="\t"+a+"\n";
		}
		return ret;
	}
	
	public Set<Agent> gererRencontre(Agent particulier) {
		Set<Agent> rencontresPossibles = new HashSet<Agent>();
		rencontresPossibles.addAll(agents);
		rencontresPossibles.remove(particulier);
		return rencontresPossibles;
		
	}
	
	/**
	 * Calculer la norme de deux agents et verifier si il y a collision
	 * */
	public boolean verifierCollision(Agent agent1, Agent agent2) {
		boolean valren = false;
		
		if( Math.sqrt( Math.pow((agent1.getCoord().getX()-agent2.getCoord().getX()),2)+Math.pow((agent1.getCoord().getY()-agent2.getCoord().getY()),2)) < rayon*rayon){valren=true;}
		
		return valren;
	}
	/**
	 * Methode permettant la supression d'un élement
	 * */
	public void supprimer(Agent supprime) {
		agents.remove(supprime); // supprime l'agent de la liste
	}

	/**
	 * génère un cycle de vie dans le monde
	 */
	public void cycle() {
		++this.cycles; // Incrémente cycle
		
		if(cycles % duree_jour == 0) {nuit = !nuit;}
		
		voisins_agent = genererVoisinsAgents(); // mis a jour de chacun des agents
		
		for(Agent particulier:agents) { // Pour chaque agent a chaque tout
			
			// 1. GERER LES COLLISIONS
			// _______________________
			
			for(Agent voisin:voisins_agent.get(particulier)){
				if(verifierCollision(particulier,voisin)){
					if(particulier instanceof Abeille){((Abeille) particulier).rencontrer(voisin);} // Utiliser la version Abeille de rencontrer voisin
					if(particulier instanceof Frelon) {((Frelon) particulier).rencontrer(voisin);} // Utiliser la version Frelon de rencontrer voisin
				}
			}
			
			// 2. CYCLE
			// ________
			
			particulier.cycle();
			
			// 3. GERER LA MORT
			// ________________
			
			if(particulier instanceof Animal) {
				if(((Animal) particulier).getNiveauSante() == Etat.Mourant){((Animal) particulier).mourrir();} // Si un animal est mourant, le faire mourir
			}
		}
	}
	
	

}
