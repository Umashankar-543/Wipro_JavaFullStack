package Assesment_4;

public class Main {
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
