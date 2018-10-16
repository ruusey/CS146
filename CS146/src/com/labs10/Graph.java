package com.labs10;

public class Graph {
		//NODES AND THEIR POSSIBLE NEIGHBORS
	  private int[][] nodes = {{5},{1},{1},{2},{2,3,7},{3},{4,6}}; // all nodes; e.g. int[][] nodes = {{1,2,3}, {3,2,1,5,6}...};

	  public int[] getAdjacentNodes(int v) {
	    return nodes[v];
	  }

	  // number of vertices in a graph
	  public int getVertices() {
	    return nodes.length;
	  }

	}