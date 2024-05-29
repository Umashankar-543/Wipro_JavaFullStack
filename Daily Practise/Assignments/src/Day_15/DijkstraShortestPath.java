package Day_15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraShortestPath {
	private static final int INF = Integer.MAX_VALUE;

	public static int[] dijkstra(int[][] graph, int start) {
		int n = graph.length;
		int[] dist = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		pq.offer(new int[] { start, 0 });
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int distance = cur[1];
			if (visited[node])
				continue;
			visited[node] = true;
			for (int neighbor = 0; neighbor < n; neighbor++) {
				if (graph[node][neighbor] != 0 && !visited[neighbor]) {
					int newDistance = distance + graph[node][neighbor];
					if (newDistance < dist[neighbor]) {
						dist[neighbor] = newDistance;
						pq.offer(new int[] { neighbor, newDistance });
					}
				}
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
				{ 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int startNode = 0;
		int[] shortestDistances = DijkstraShortestPath.dijkstra(graph, startNode);
		System.out.println("Shortest distances from node " + startNode + ":");
		for (int i = 0; i < shortestDistances.length; i++) {
			System.out.println("To node " + i + ": " + shortestDistances[i]);
		}
	}
}
