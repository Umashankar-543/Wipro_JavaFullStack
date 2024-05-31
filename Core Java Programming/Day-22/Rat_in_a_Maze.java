package Day_22;

public class Rat_in_a_Maze {
	private static final int N = 6;

	public static boolean solveMaze(int[][] maze) {
		int[][] solution = new int[N][N];
		if (!solveMazeUtil(maze, 0, 0, solution)) {
			System.out.println("No solution exists");
			return false;
		}
		printSolution(solution);
		return true;
	}

	private static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution) {
		if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
			solution[x][y] = 1;
			return true;
		}
		if (isSafe(maze, x, y)) {
			solution[x][y] = 1;
			if (solveMazeUtil(maze, x + 1, y, solution))
				return true;
			if (solveMazeUtil(maze, x, y + 1, solution))
				return true;
			solution[x][y] = 0;
			return false;
		}
		return false;
	}

	private static boolean isSafe(int[][] maze, int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1);
	}

	private static void printSolution(int[][] solution) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] maze = { { 1, 0, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 0 },
				{ 1, 0, 0, 0, 1, 0 }, { 1, 1, 1, 0, 1, 1 } };
		solveMaze(maze);
	}
}
