package Day_21;

public class KnightsTour {
	private static final int N = 8;
	private static final int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

	private static boolean solveKnightsTour(int[][] board, int moveX, int moveY, int moveCount) {
		if (moveCount == N * N) {
			return true;
		}
		for (int i = 0; i < N; i++) {
			int nextX = moveX + xMove[i];
			int nextY = moveY + yMove[i];
			if (isSafe(nextX, nextY, board)) {
				board[nextX][nextY] = moveCount;
				if (solveKnightsTour(board, nextX, nextY, moveCount + 1)) {
					return true;
				} else {
					board[nextX][nextY] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isSafe(int x, int y, int[][] board) {
		return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
	}

	private static void printSolution(int[][] board) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				System.out.print(board[x][y] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] board = new int[N][N];
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				board[x][y] = -1;
			}
		}
		board[0][0] = 0;
		if (!solveKnightsTour(board, 0, 0, 1)) {
			System.out.println("Solution does not exist");
		} else {
			printSolution(board);
		}
	}
}