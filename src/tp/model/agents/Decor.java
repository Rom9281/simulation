package tp.model.agents;

import java.awt.Point;

public class Decor {
	protected Point coord;
	
	public Decor(Point point) {
		coord = point;
	}
	
	public Decor() {
		Decor(new Point(0,0));
	}

}
