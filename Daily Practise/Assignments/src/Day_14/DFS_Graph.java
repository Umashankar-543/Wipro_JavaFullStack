package Day_14;

import java.util.LinkedList;

public class DFS_Graph {
	private int numVertices;
	private LinkedList<Integer>[] adjLists;

	@SuppressWarnings("unchecked")
	public DFS_Graph(int vertices) {
		numVertices = vertices;
		adjLists = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjLists[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		adjLists[src].add(dest);
		adjLists[dest].add(src);
	}

	public void DFS(int startVertex) {
		boolean[] visited = new boolean[numVertices];
		DFSUtil(startVertex, visited);
	}

	private void DFSUtil(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for (int adjVertex : adjLists[vertex]) {
			if (!visited[adjVertex]) {
				DFSUtil(adjVertex, visited);
			}
		}
	}

	public static void main(String[] args) {
		DFS_Graph g = new DFS_Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		System.out.println("Depth-First Traversal starting from vertex 0:");
		g.DFS(0);
	}
}
