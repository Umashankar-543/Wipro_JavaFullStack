package Assignment_5;

public class Main {

	public static void main(String[] args) {

		BFS_Graph g = new BFS_Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 5);
		System.out.println("Breadth-First Traversal starting from vertex 0:");
		g.BFS(0);
	}
}
