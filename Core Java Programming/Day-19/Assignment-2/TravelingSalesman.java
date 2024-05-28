package Day_19.Assignment_2;

import java.util.Arrays;

public class TravelingSalesman {

	public static int FindMinCost(int[][] graph) {
		int n = graph.length;
		int VISITED_ALL = (1 << n) - 1;
		int[][] dp = new int[n][(1 << n)];
		for (int[] row : dp) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dp[0][1] = 0;
		for (int mask = 1; mask < (1 << n); mask++) {
			for (int u = 0; u < n; u++) {
				if ((mask & (1 << u)) != 0) {
					for (int v = 0; v < n; v++) {
						if ((mask & (1 << v)) == 0) {
							int nextMask = mask | (1 << v);
							dp[v][nextMask] = Math.min(dp[v][nextMask], dp[u][mask] + graph[u][v]);
						}
					}
				}
			}
		}
		int minCost = Integer.MAX_VALUE;
		for (int u = 1; u < n; u++) {
			minCost = Math.min(minCost, dp[u][VISITED_ALL] + graph[u][0]);
		}
		return minCost;
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 10, 15, 20 }, { 10, 0, 35, 25 }, { 15, 35, 0, 30 }, { 20, 25, 30, 0 } };
		int minCost = FindMinCost(graph);
		System.out.println("The minimum cost to visit all cities and return to the starting city is: " + minCost);
	}
}