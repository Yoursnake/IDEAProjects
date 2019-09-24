/*
Write an efficient algorithm that searches for a value in an m x n 
matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
Example:

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
*/

public class LeetCode240Searcha2DMatrixII {
 //    // DFS + divide : 5% 23ms
	// public boolean searchMatrix(int[][] matrix, int target) {
	// 	int row = matrix.length;
	// 	if (row == 0) return false;
	// 	int col = matrix[0].length;
	// 	if (col == 0) return false;
	// 	if (matrix[row - 1][col - 1] < target) return false;

	// 	int[] start = findStartPoint(matrix, target);

	// 	boolean[][] visited = new boolean[matrix.length][matrix[0].length];

	// 	return searchDFS(matrix, target, start[0], start[1], visited);
	// }

	// // 用二分找初始节点
	// private int[] findStartPoint(int[][] matrix, int target) {
	// 	int row = matrix.length;
	// 	int col = matrix[0].length;
	// 	int startX = -1;
	// 	int startY = -1;

	// 	int left = 0;
	// 	int right = row - 1;
	// 	while (left <= right) {
	// 		int mid = (right + left) / 2;
	// 		if (mid == 0) {
	// 			if (target <= matrix[mid][col - 1]) {startX = mid; break;}
	// 			else left = mid + 1;
	// 		} else {
	// 			if (matrix[mid - 1][col - 1] < target && target <= matrix[mid][col - 1]) {startX = mid; break;}
	// 			else if (target <= matrix[mid - 1][col - 1]) right = mid - 1;
	// 			else left = mid + 1;
	// 		}
	// 	}

	// 	left = 0;
	// 	right = col - 1;
	// 	while (left <= right) {
	// 		int mid = (right + left) / 2;
	// 		if (mid == 0) {
	// 			if (target <= matrix[row - 1][mid]) {startY = mid; break;}
	// 			else left = mid + 1;
	// 		} else {
	// 			if (matrix[row - 1][mid - 1] < target && target <= matrix[row - 1][mid]) {startY = mid; break;}
	// 			else if (target <= matrix[row - 1][mid - 1]) right = mid - 1;
	// 			else left = mid + 1;
	// 		}
	// 	}

	// 	return new int[] {startX, startY};
	// }

	// // DFS 搜索
	// private boolean searchDFS(int[][] matrix, int target, int x, int y, boolean[][] visited) {
	// 	if (x >= matrix.length || y >= matrix[0].length) return false;
	// 	if (matrix[x][y] > target) return false;
	// 	if (matrix[x][y] == target) return true;
	// 	if (visited[x][y]) return false;		

	// 	visited[x][y] = true;
	// 	return searchDFS(matrix, target, x + 1, y, visited) | searchDFS(matrix, target, x, y + 1, visited);
	// }

	// // divide: 29.87% 6ms 两次二分 
	// public boolean searchMatrix(int[][] matrix, int target) {
	// 	if (matrix.length == 0 || matrix[0].length == 0) return false; 

	// 	int row = matrix.length;
	// 	int col = matrix[0].length;
	// 	int left = 0, right = row - 1;
	// 	while (left < right) {
	// 		int mid = (left + right) / 2;
	// 		if (matrix[mid][0] < target) left = mid + 1;
	// 		else if (matrix[mid][0] > target) right = mid - 1;
	// 		else return true;
	// 	}

	// 	for (int i = right; i < col; i++) {
	// 		if (matrix[i][0] > target) continue;

	// 		int l = 0, r = col - 1;
	// 		while (l <= r) {
	// 			int mid = (l + r) / 2;
	// 			if (matrix[i][mid] < target) l = mid + 1;
	// 			else if (matrix[i][mid] > target) r = mid - 1;
	// 			else return true;
	// 		}
	// 	}

	// 	return false;
	// }

	// divide: 分治 100% 5ms
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;

		int row = matrix.length;
		int col = matrix[0].length;
		int i = 0;
		int j = col - 1;

		while (i < row && j >= 0) {
			if (matrix[i][j] > target) j--;
			else if (matrix[i][j] < target) i++;
			else return true;
		}

		return false;
	}
}