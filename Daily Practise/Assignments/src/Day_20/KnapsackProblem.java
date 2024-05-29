package Day_20;

public class KnapsackProblem {
	public static int knapsack(int W, int[] weights, int[] values) {
		int n = values.length;
		int[][] dp = new int[n + 1][W + 1];
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					dp[i][w] = 0;
				} else if (weights[i - 1] <= w) {
					dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		return dp[n][W];
	}

	public static void main(String[] args) {
		int W = 50;
		int[] weights = { 10, 20, 30, 40, 50 };
		int[] values = { 60, 100, 120, 200, 240 };
		System.out.println("Maximum value in Knapsack = " + knapsack(W, weights, values));
	}
}