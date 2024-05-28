package Assignment_3;

public class Main {

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };
		UnionFind uf = new UnionFind(n);
		if (uf.detectCycle(edges)) {
			System.out.println("Cycle detected.");
		} else {
			System.out.println("No cycle detected.");
		}
	}
}