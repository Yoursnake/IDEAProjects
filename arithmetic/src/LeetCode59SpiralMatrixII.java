/*
Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

public class LeetCode59SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowPoint = 0;
        int colPoint = 0;
        int orient = 0; // 0 右 1 下 2 左 3 上

        for (int i = 0; i < n * n; i++) {
            matrix[rowPoint][colPoint] = i + 1;

            switch (orient) {
                case 0:
                    if (colPoint <= n - 2 && matrix[rowPoint][colPoint + 1] == 0) {
                        colPoint++;
                    } else {
                        orient++; orient %= 4;
                        rowPoint++;
                    } break;
                case 1:
                    if (rowPoint <= n - 2 && matrix[rowPoint + 1][colPoint] == 0) {
                        rowPoint++;
                    } else {
                        orient++; orient %= 4;
                        colPoint--;
                    } break;
                case 2:
                    if (colPoint >= 1 && matrix[rowPoint][colPoint - 1] == 0) {
                        colPoint--;
                    } else {
                        orient++; orient %= 4;
                        rowPoint--;
                    } break;
                case 3:
                    if (rowPoint >= 1 && matrix[rowPoint - 1][colPoint] == 0) {
                        rowPoint--;
                    } else {
                        orient++; orient %= 4;
                        colPoint++;
                    } break;
            }
        }

        return matrix;
    }
}
