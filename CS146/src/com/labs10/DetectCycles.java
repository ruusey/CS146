package com.labs10;

import java.util.ArrayList;
import java.util.List;

public class DetectCycles {

	private boolean marked[];
	private boolean onStack[];
	private Graph graph;
	private boolean hasCycle;

	public DetectCycles(Graph graph) {
		this.graph = graph;

		marked = new boolean[graph.getVertices()];
		onStack = new boolean[graph.getVertices()];
		for (int x = 1; x < 8; x++) {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(x);
			findCycle(graph, x, path);
			marked = new boolean[graph.getVertices()];
			onStack = new boolean[graph.getVertices()];

		}

	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public void findCycle(Graph g, int start, List<Integer> list) {
		// Visited Nodes and ones in the current cycle.
		marked[start - 1] = true;
		onStack[start - 1] = true;

		for (int w : g.getAdjacentNodes(start - 1)) {

			if (!marked[w - 1]) {
				list.add(w);

				findCycle(g, w, copyList(list));
				list.remove(list.size() - 1);

			} else if (onStack[w - 1]) {
				list.add(w);
				hasCycle = true;
				printPath(list);

				return;
			}
		}

		onStack[start - 1] = false;
	}

	public ArrayList<Integer> copyList(List<Integer> list) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			result.add(list.get(i));
		}
		return result;
	}

	public void printPath(List<Integer> path) {
		for (int i : path) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public void printResult(boolean[] marked, int start) {
		for (int i = 0; i < marked.length; i++) {
			if (marked[i] == true) {
				System.out.print((i + 1) + " ");
			}

		}
		System.out.print(start);
		System.out.println();
	}
}
