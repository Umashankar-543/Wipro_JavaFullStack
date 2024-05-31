package Day_15;

public class UnionFind {
	private int[] parent;
	private int[] rank;

	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX != rootY) {
			if (rank[rootX] > rank[rootY]) {
				parent[rootY] = rootX;
			} else if (rank[rootX] < rank[rootY]) {
				parent[rootX] = rootY;
			} else {
				parent[rootY] = rootX;
				rank[rootX]++;
			}
		}
	}

	public boolean detectCycle(int[][] edges) {
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int rootU = find(u);
			int rootV = find(v);
			if (rootU == rootV) {
				return true;
			} else {
				union(u, v);
			}
		}
		return false;
	}

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
}