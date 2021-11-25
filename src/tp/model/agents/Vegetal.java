package tp.model.agents;

import java.awt.Point;

public class Vegetal extends Agent {

	public Vegetal(Point coord) {
		super();
		this.coord = new Point(coord);
	}
	public Vegetal() {
		this(new Point(0,0));
	}

}
