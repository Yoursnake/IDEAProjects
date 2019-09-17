/*
Given a 2D binary matrix filled with 0's and 1's, find the largest 
square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/

public class LeetCode221MaximalSquare {
	// DFS: 99.52%
	public int maximalSquare(char[][] matrix) {
		if (matrix.length == 0) return 0;

		int result = 0;
		int rowLen = matrix.length;
		int colLen = matrix[0].length;
		for (int i = 0; i < rowLen; i++) {
			for (int j = 0; j < colLen; j++) {
				if (matrix[i][j] == '1') {
					int area = DFS(matrix, 1, i, j);
					result = Math.max(result, area);
				}
			}
		}

		return result;
    }

    private int DFS(char[][] matrix, int index, int initRow, int initCol) {
    	if (initRow + index >= matrix.length || initCol + index >= matrix[0].length) return index * index;

    	for (int i = initRow; i <= initRow + index; i++) {
    		if (matrix[i][initCol + index] == '0') return index * index;
    	}

    	for (int i = initCol; i <= initCol + index - 1; i++) {
    		if (matrix[initRow + index][i] == '0') return index * index;
    	}

    	return DFS(matrix, index + 1, initRow, initCol);
    }
}