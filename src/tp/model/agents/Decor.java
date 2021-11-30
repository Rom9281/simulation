package tp.model.agents;

import java.awt.Point;

public class Decor {
	/*
	 * Variables
	 * */
	
	protected Point coord;
	
	/*
	 * Constructeurs
	 * */
	
	public Decor(Point point) {
		super();
		this.coord = new Point(point); // Permet de copier le contenu du point donné dans un nouveau point
	}
	
	public Decor(){
		this(new Point(0,0)); // Appel du constructeur ayant un point
	}
	
	public Point getCoord() {
		return new Point(coord); // On retourne une copie du point, pas la vrai version.
	}
	
	/*
	 * HashCode and equals
	 * */
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Decor other = (Decor) obj;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		return true;
	}
	
	/*
	 * Méthodes
	 * */

	
	

}
