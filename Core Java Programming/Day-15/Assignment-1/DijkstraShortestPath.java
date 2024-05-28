package Assignment_1;

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
}
