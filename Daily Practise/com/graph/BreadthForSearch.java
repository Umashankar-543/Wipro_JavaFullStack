package com.graph;

import java.util.LinkedList;

public class BreadthForSearch {
	private int numVertices;
	private LinkedList<Integer>[] adjLists;

	@SuppressWarnings("unchecked")
	public BreadthForSearch(int vertices) {
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

	public static void main(String[] args) {
		BreadthForSearch g = new BreadthForSearch(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		System.out.println("Breadth First Traversal starting from vertex 0:");
		g.BFS(0);
	}
}
