package Day_13;

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

	public static void main(String[] args) {
		int V = 4;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		int u = 1, v = 3;
		boolean isValid = graph.validateEdgeAddition(u, v);
		System.out.println("Is edge addition valid? " + isValid);
	}
}