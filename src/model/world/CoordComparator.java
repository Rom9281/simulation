package model.world;

import java.util.Comparator;

import model.agents.Agent;

/**
 * Comparateur d'agents basé sur les coordonnés
 * */
public class CoordComparator implements Comparator<Agent>{

	@Override
	/**
	 * Methode de comparaison de deux agents basés sur leur coordonnés
	 * */
	public int compare(Agent agent1, Agent agent2) {
		
		int valren = 0;
		
		if(agent1.getCoord().getX() > agent2.getCoord().getX()) {valren = 1;}
		else if(agent1.getCoord().getX() < agent2.getCoord().getX()) {valren = -1;}
		else { // Cas d'egalité sur la variable x
			if(agent1.getCoord().getY() > agent2.getCoord().getY()) {valren = 1;}
			else if(agent1.getCoord().getY() < agent2.getCoord().getY()) {valren = -1;}
			else {valren = -1;} // Cas d'églaité, la deuxieme vient après la premieres
		}
		
		return valren; 
	}

}
