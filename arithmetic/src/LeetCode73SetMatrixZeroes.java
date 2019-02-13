/*
Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
 */
public class LeetCode73SetMatrixZeroes {

//    // 空间复杂度 O(m+n)
//    public void setZeroes(int[][] matrix) {
//        int row = matrix.length;
//        int col = matrix[0].length;
//        boolean[] rowFlag = new boolean[row];
//        boolean[] colFlag = new boolean[col];
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (matrix[i][j] == 0) {
//                    rowFlag[i] = true;
//                    colFlag[j] = true;
//                }
//            }
//        }
//
//        for (int i = 0; i < row; i++) {
//            if (rowFlag[i]) {
//                for (int j = 0; j < col; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        for (int i = 0; i < col; i++) {
//            if (colFlag[i]) {
//                for (int j = 0; j < row; j++) {
//                    matrix[j][i] = 0;
//                }
//            }
//        }
//    }

    // 空间复杂度O(1)
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false;    // 表示第一行是否有 0
        boolean colFlag = false;    // 表示第一列是否有 0
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        // 找除了第一行和第一列的元素是否有0， 如果有存储在matrix的第一行和第一列
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 对行置零
        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 对列置零
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // 对第一行置零
        if (rowFlag) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }

        // 对第一列置零
        if (colFlag) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
