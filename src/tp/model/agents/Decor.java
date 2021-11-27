package tp.model.agents;

import java.awt.Point;

public class Decor {
	protected Point coord;
	
	
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

}
