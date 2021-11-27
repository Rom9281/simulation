package tp.model.agents;

import java.awt.Point;
import java.util.Objects;

public class Agent {

	protected static int currentId = 0;
	/** identifiant unique de l'animal*/
	protected int id;
	/** age en unité de temps*/
	protected int age;
	/** position sur la carte*/
	protected Point coord;

	
	
	public Agent(Point point) {
		super();
		this.coord = new Point(point);
	}
	
	public Agent() {
		this(new Point(0,0));
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public Point getCoord() {
		return new Point(this.coord); // Sinon this (Point) this.coord.clone()
	}

	public String toString() {
		String ret_str = this.getClass().getSimpleName()+" n� "+id+"(, "+this.getCoord().getX()+","+this.getCoord().getY()+").";
		return ret_str;
	}

	public void vieillir() {
		//TODO fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
		
		//this.setAge(this.getAge()+1);
		this.age++;
	}

	public void rencontrer(Animal a) {
		//TODO
	}

	@Override
	public int hashCode() {
		return Objects.hash(age);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return age == other.getAge();
	}

}