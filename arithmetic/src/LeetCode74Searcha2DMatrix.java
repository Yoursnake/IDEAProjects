/*
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true

Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */
public class LeetCode74Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) return false;

        int targetRow = -1;

        // 找target所在的行
        if (row == 1) {
            targetRow = 0;
        } else {
            for (int i = 0; i < row - 1; i++) {
                if (matrix[i][0] == target) return true;
                if (matrix[i][0] < target && target < matrix[i + 1][0]) {
                    targetRow = i;
                }
            }
            if (targetRow == -1) targetRow = row - 1;   // 边界
        }

        // 二分法找元素
        int low = 0, high = col - 1;
        while (true) {
            int mid = (low + high) / 2;
            if (matrix[targetRow][mid] == target) return true;
            else if (matrix[targetRow][mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

            if (low > high) return false;
        }
    }
}
