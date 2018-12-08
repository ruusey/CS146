package com.hw9;

import java.util.ArrayList;

public class BridgeGraph {

	public ArrayList<LandArea> landAreas = new ArrayList<LandArea>();
	public static final int NUMBER_BRIDGES = 16;
	public BridgeGraph() {
		// Create all 6 quadrants and put them in the hash
		LandArea l0 = new LandArea(0);
		LandArea l1 = new LandArea(1);
		LandArea l2 = new LandArea(2);
		LandArea l3 = new LandArea(3);
		LandArea l4 = new LandArea(4);
		LandArea l5 = new LandArea(5);

		landAreas.add(l0);
		landAreas.add(l1);
		landAreas.add(l2);
		landAreas.add(l3);
		landAreas.add(l4);
		landAreas.add(l5);

		Bridge bridge = null;
		//CONSTRUCTOR ADDS TO LIST NO NEED TO DO ANYTHING ELSE
		bridge = new Bridge(l0, l1);
		bridge = new Bridge(l0, l1);
		bridge = new Bridge(l0, l2);
		bridge = new Bridge(l0, l2);
		bridge = new Bridge(l0, l3);
		bridge = new Bridge(l0, l3);
		bridge = new Bridge(l0, l4);
		bridge = new Bridge(l0, l5);
		bridge = new Bridge(l0, l5);
		bridge = new Bridge(l1, l2);
		bridge = new Bridge(l1, l3);
		bridge = new Bridge(l1, l4);
		bridge = new Bridge(l2, l4);
		bridge = new Bridge(l2, l5);
		bridge = new Bridge(l3, l4);
		bridge = new Bridge(l4, l5);

	}

}
