package Assignment_5;

import java.util.LinkedList;

public class BFS_Graph {

	private int numVertices;
	private LinkedList<Integer>[] adjLists;

	@SuppressWarnings("unchecked")
	public BFS_Graph(int vertices) {
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

	public void BFS(int startVertex) {
		boolean[] visited = new boolean[numVertices];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[startVertex] = true;
		queue.add(startVertex);
		while (!queue.isEmpty()) {
			int vertex = queue.poll();
			System.out.print(vertex + " ");
			for (int adjVertex : adjLists[vertex]) {
				if (!visited[adjVertex]) {
					visited[adjVertex] = true;
					queue.add(adjVertex);
				}
			}
		}
	}
}
