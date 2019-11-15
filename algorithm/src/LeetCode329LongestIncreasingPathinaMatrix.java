/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or 
down. You may NOT move diagonally or move outside of the boundary (i.e. 
wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
*/

public class LeetCode329LongestIncreasingPathinaMatrix {
	// DFS+Map: 8ms 72.72%
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

		int row = matrix.length;
		int col = matrix[0].length;
		int[][] map = new int[row][col];    // 用于表示从 i j 开始的最长递增序列
		// boolean[][] visited = new boolean[row][col]; // 不需要 visited，因为递增数列不可能走重复的

		int res = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				res = Math.max(res, findLongestPath(matrix, i, j, Integer.MIN_VALUE, map));
			}
		}

		return res;
	}

	private static final int[][] diffs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

	// DFS 找从 x y 开始的最长递增序列长度
	private int findLongestPath(int[][] matrix, int x, int y, int last, int[][] map) {
		int row = matrix.length;
		int col = matrix[0].length;

		if (x < 0 || x >= row || y < 0 || y >= col) return 0;
		if (matrix[x][y] <= last) return 0;     // 必须递增
		if (map[x][y] != 0) return map[x][y];   // 不等于0表示已经算过了该点的最长递增长度

		int res = 0;

		for (int[] diff : diffs) {
			int nextX = x + diff[0];
			int nextY = y + diff[1];

			res = Math.max(res, findLongestPath(matrix, nextX, nextY, matrix[x][y], map));
		}
		map[x][y] = 1 + res;

		return 1 + res;
	}
}