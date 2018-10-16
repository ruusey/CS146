package com.hw9;

import java.util.ArrayList;

public class BridgeGraph {

	public ArrayList<Quadrant> quadrants = new ArrayList<Quadrant>();
	public static final int NUMBER_BRIDGES = 16;
	public BridgeGraph() {
		// Create all 6 quadrants and put them in the hash
		Quadrant quad0 = new Quadrant(0);
		Quadrant quad1 = new Quadrant(1);
		Quadrant quad2 = new Quadrant(2);
		Quadrant quad3 = new Quadrant(3);
		Quadrant quad4 = new Quadrant(4);
		Quadrant quad5 = new Quadrant(5);

		quadrants.add(quad0);
		quadrants.add(quad1);
		quadrants.add(quad2);
		quadrants.add(quad3);
		quadrants.add(quad4);
		quadrants.add(quad5);

		Bridge bridge = null;
		//CONSTRUCTOR ADDS TO LIST NO NEED TO DO ANYTHING ELSE
		bridge = new Bridge(quad0, quad1);
		bridge = new Bridge(quad0, quad1);
		bridge = new Bridge(quad0, quad2);
		bridge = new Bridge(quad0, quad2);
		bridge = new Bridge(quad0, quad3);
		bridge = new Bridge(quad0, quad3);
		bridge = new Bridge(quad0, quad4);
		bridge = new Bridge(quad0, quad5);
		bridge = new Bridge(quad0, quad5);
		bridge = new Bridge(quad1, quad2);
		bridge = new Bridge(quad1, quad3);
		bridge = new Bridge(quad1, quad4);
		bridge = new Bridge(quad2, quad4);
		bridge = new Bridge(quad2, quad5);
		bridge = new Bridge(quad3, quad4);
		bridge = new Bridge(quad4, quad5);

	}

}
