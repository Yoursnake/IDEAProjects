/*
Given a 2D matrix matrix, find the sum of the elements inside the 
rectangle defined by its upper left corner (row1, col1) and lower 
right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) 
and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:
You may assume that the matrix does not change.
There are many calls to sumRegion function.
You may assume that row1 ≤ row2 and col1 ≤ col2.
*/

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

// 75% 56ms
public class LeetCode304RangeSumQuery2DImmutable {
	private int[][] cumsum;

	public LeetCode304RangeSumQuery2DImmutable(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

		int row = matrix.length;
		int col = matrix[0].length;
        cumsum = new int[row][col];
        cumsum[0][0] = matrix[0][0];

        for (int i = 1; i < row; i++) {
        	cumsum[i][0] = cumsum[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j < col; j++) {
        	cumsum[0][j] = cumsum[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i < row; i++) {
        	for (int j = 1; j< col; j++) {
        		cumsum[i][j] = cumsum[i - 1][j] + cumsum[i][j - 1] - cumsum[i - 1][j - 1] + matrix[i][j];
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return cumsum[row2][col2];
        else if (row1 != 0 && col1 == 0) return cumsum[row2][col2] - cumsum[row1 - 1][col2];
        else if (row1 == 0 && col1 != 0) return cumsum[row2][col2] - cumsum[row2][col1 - 1];
        else return cumsum[row2][col2]  - cumsum[row1 - 1][col2] - cumsum[row2][col1 - 1] + cumsum[row1 - 1][col1 - 1];
    }
}