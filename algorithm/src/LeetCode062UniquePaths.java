/*
Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28
 */

public class LeetCode062UniquePaths {

    public int uniquePaths(int m, int n) {
        // 构造一个矩阵，存储每一格到达终点有多少条路
        int[][] pathNum = new int[n][m];

        // 从最后一行开始赋值，最后一行每一格到终点都只有一条路径
        for (int i = 0; i < m; i++) {
            pathNum[n - 1][i] = 1;
        }

        // 然后从最后一行慢慢往上赋值
        for (int i = n - 2; i >= 0; i--) {
            // 每行的最后一列到终点也只有一条路径
            pathNum[i][m - 1] = 1;

            // 每格的路径数均等于下面一格的路径数加上右边一格的路径数
            for (int j = m - 2; j >= 0; j--) {
                pathNum[i][j] = pathNum[i + 1][j] + pathNum[i][j + 1];
            }
        }

        return pathNum[0][0];
    }

}
