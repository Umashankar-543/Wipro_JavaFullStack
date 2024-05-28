package Assignment_6;

public class Main {

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
