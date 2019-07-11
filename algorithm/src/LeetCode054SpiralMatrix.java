/*
Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

import java.util.ArrayList;
import java.util.List;

public class LeetCode054SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }

        int col = matrix[0].length;
        boolean[][] isUsed = new boolean[row][col];
        int gridNum = row * col;

        int rowCur = 0;
        int colCur = 0;
        int orient = 0; // 0 右 1 下 2 左 3 上

        for (int i = 0; i < gridNum; i++) {
            result.add(matrix[rowCur][colCur]);
            isUsed[rowCur][colCur] = true;

            switch (orient) {
                case 0:
                    colCur++;
                    if (colCur == col || isUsed[rowCur][colCur] == true) {
                        colCur--;
                        rowCur++;
                        orient++;
                    }
                    break;
                case 1:
                    rowCur++;
                    if (rowCur == row || isUsed[rowCur][colCur] == true) {
                        rowCur--;
                        colCur--;
                        orient++;
                    }
                    break;
                case 2:
                    colCur--;
                    if (colCur == -1 || isUsed[rowCur][colCur] == true) {
                        colCur++;
                        rowCur--;
                        orient++;
                    }
                    break;
                case 3:
                    rowCur--;
                    if (rowCur == -1 || isUsed[rowCur][colCur] == true) {
                        rowCur++;
                        colCur++;
                        orient++;
                    }
                    break;
            }

            orient %= 4;
        }

        return result;
    }
}
