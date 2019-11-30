/*
Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

Example:

Input: matrix = [[1,0,1],[0,-2,3]], k = 2
Output: 2 
Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
             and 2 is the max number no larger than k (k = 2).
Note:

1. The rectangle inside the matrix must have an area > 0.
2. What if the number of rows is much larger than the number of columns?
*/

import java.util.*;

public class LeetCode363MaxSumofRectangleNoLargerThanK {
	// // brute force: O(n^4) 105ms 43.5%
	// public int maxSumSubmatrix(int[][] matrix, int k) {
	// 	int row = matrix.length;
	// 	int col = matrix[0].length;
	// 	int[][] cumsum = new int[row + 1][col + 1];

	// 	// 先算前 i,j 的元素和 O(n^2)
	// 	for (int i = 1; i < row + 1; i++) {
	// 		for (int j = 1; j < col + 1; j++) {
	// 			cumsum[i][j] = cumsum[i - 1][j] + cumsum[i][j - 1] + matrix[i - 1][j - 1] - cumsum[i - 1][j - 1];
	// 		}
	// 	}

	// 	// 计算每对组合的大小 O(n^4)
	// 	int max = Integer.MIN_VALUE;
	// 	// (i1, j1) --> (i2, j2)
	// 	for (int i1 = 1; i1 < row + 1; i1++) {
	// 		for (int j1 = 1; j1 < col + 1; j1++) {
	// 			for (int i2 = i1; i2 < row + 1; i2++) {
	// 				for (int j2 = j1; j2 < col + 1; j2++) {
	// 					int tmp = cumsum[i2][j2] - cumsum[i1 - 1][j2]
	// 							- cumsum[i2][j1 - 1] + cumsum[i1 - 1][j1 - 1];
	// 					if (tmp > max && tmp <= k) {
	// 						max = tmp;
	// 					}
	// 				}
	// 			}
	// 		}
	// 	}

	// 	return max;
	// }

	// O(n^3logn) 350ms 20.6%
	public int maxSumSubmatrix(int[][] matrix, int k) {
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] cumsum = new int[row + 1][col + 1];
		// 先算前 i,j 的元素和 O(n^2)
		for (int i = 1; i < row + 1; i++) {
			for (int j = 1; j < col + 1; j++) {
				cumsum[i][j] = cumsum[i - 1][j] + cumsum[i][j - 1] + matrix[i - 1][j - 1] - cumsum[i - 1][j - 1];
			}
		}

		int max = Integer.MIN_VALUE;
		// 先把两个行定下，对于每一列计算对应的 area，然后找比 area-k 大的最小值 ceiling，这样 area-ceiling 就是当前列的最大值
		for (int i1 = 1; i1 < row + 1; i1++) {
			for (int i2 = i1; i2 < row + 1; i2++) {
				TreeSet<Integer> tree = new TreeSet<>();
				tree.add(0);
				for (int c = 1; c < col + 1; c++) {
					int area = cumsum[i2][c] - cumsum[i1 - 1][c];
					Integer ceiling = tree.ceiling(area - k);
					if (ceiling != null) max = Math.max(max, area - ceiling);
					tree.add(area);
				}
			}
		}

		return max;
	}
}