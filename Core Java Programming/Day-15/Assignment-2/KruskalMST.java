package Assignment_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
	int src, dest, weight;

	public Edge(int src, int dest, int weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
}

class Subset {
	int parent, rank;
}

public class KruskalMST {
	int vertices;
	List<Edge> edges;

	public KruskalMST(int vertices) {
		this.vertices = vertices;
		edges = new ArrayList<>();
	}

	public void addEdge(int src, int dest, int weight) {
		edges.add(new Edge(src, dest, weight));
	}

	public int find(Subset[] subsets, int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	public void union(Subset[] subsets, int x, int y) {
		int xRoot = find(subsets, x);
		int yRoot = find(subsets, y);
		if (subsets[xRoot].rank < subsets[yRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else if (subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}

	public void kruskalMST() {
		List<Edge> result = new ArrayList<>();
		Collections.sort(edges);
		Subset[] subsets = new Subset[vertices];
		for (int i = 0; i < vertices; ++i) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		int i = 0;
		while (result.size() < vertices - 1) {
			Edge nextEdge = edges.get(i++);
			int x = find(subsets, nextEdge.src);
			int y = find(subsets, nextEdge.dest);
			if (x != y) {
				result.add(nextEdge);
				union(subsets, x, y);
			}
		}
		System.out.println("Edges in the Minimum Spanning Tree:");
		for (Edge edge : result) {
			System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
		}
	}
}