/*
Example 1:

Given input matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

Example 2:

Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

 */

public class LeetCode48RotateImage {
//    public void rotate(int[][] matrix) {
//        int sideLen = matrix.length;
//        int rotateNum = sideLen / 2;
//
//        // 一共有 rotateNum 圈
//        for (int i = 0; i < rotateNum; i++) {
//            int rotateLen = sideLen - 2 * i;
//
//            // 每圈都需要转 rotateLen - 1 次
//            for (int j = 0; j < rotateLen - 1; j++) {
//                int xIndex = i;
//                int yIndex = i;
//                int lastVal = matrix[i][i];
//                int step = 0;
//                int orient = 0; // 0右 1下 2左 3上
//
//                do {
//                    switch (orient) {
//                        case 0:
//                            yIndex++;break;
//                        case 1:
//                            xIndex++;break;
//                        case 2:
//                            yIndex--;break;
//                        case 3:
//                            xIndex--;break;
//                    }
//
//                    int temp = matrix[xIndex][yIndex];
//                    matrix[xIndex][yIndex] = lastVal;
//                    lastVal = temp;
//
//                    step++;
//                    // 每一个方向走 rotateLen - 1 步后改变方向
//                    if (step == rotateLen - 1) {
//                        step = 0;
//                        orient++;
//                        orient %= 4;
//                    }
//
//                } while (xIndex != i || yIndex != i);   // 转到开头时停下来
//            }
//        }
//    }


    public void rotate(int[][] matrix) {
        int sideLen = matrix.length;
        int rotateNum = sideLen / 2;

        // 一共有 rotateNum 圈
        for (int i = 0; i < rotateNum; i++) {
            int rotateLen = sideLen - 2 * i;

            int xIndex = i;
            int yIndex = i;
            int[] lastVals = new int[rotateLen - 1];    // 上一排的数据
            int tempIndex = 0;
            for (int j = xIndex + rotateLen - 2; j >= i; j--) {
                lastVals[tempIndex++] = matrix[j][yIndex];
            }

            int orient = 0; // 0右 1下 2左 3上
            int step = 0;

            do {
                switch (orient) {
                    case 0:
                        yIndex++;break;
                    case 1:
                        xIndex++;break;
                    case 2:
                        yIndex--;break;
                    case 3:
                        xIndex--;break;
                }

                int temp = matrix[xIndex][yIndex];
                matrix[xIndex][yIndex] = lastVals[step];
                lastVals[step] = temp;

                step++;
                // 每一个方向走 rotateLen - 1 步后改变方向
                if (step == rotateLen - 1) {
                    step = 0;
                    orient++;
                    orient %= 4;
                }

            } while (xIndex != i || yIndex != i);   // 转到开头时停下来
        }
    }
}
