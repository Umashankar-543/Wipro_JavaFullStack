package Assesment_4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int V;
	private List<List<Integer>> adj;

	public Graph(int V) {
		this.V = V;
		adj = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v) {
		adj.get(u).add(v);
	}

	public boolean hasCycle(int u, boolean[] visited, boolean[] recStack) {
		if (!visited[u]) {
			visited[u] = true;
			recStack[u] = true;
			for (Integer v : adj.get(u)) {
				if (!visited[v] && hasCycle(v, visited, recStack)) {
					return true;
				} else if (recStack[v]) {
					return true;
				}
			}
		}
		recStack[u] = false;
		return false;
	}

	public boolean isCyclic() {
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (hasCycle(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	public boolean validateEdgeAddition(int u, int v) {
		addEdge(u, v);
		boolean cycle = isCyclic();
		if (cycle) {
			adj.get(u).remove(adj.get(u).size() - 1);
		}
		return !cycle;
	}
}