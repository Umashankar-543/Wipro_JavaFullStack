package Assignment_6;

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
}
