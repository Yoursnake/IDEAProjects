public class LeetCode63UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] pathNum = new int[row + 1][col + 1];    // 外面多加一圈 0

        if (obstacleGrid[row - 1][col - 1] == 1) return 0;
        else pathNum[row - 1][col - 1] = 1;

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i == row - 1 && j == col - 1) continue; // 最后一个元素就是 1 不用算

                if (obstacleGrid[i][j] == 0) {
                    pathNum[i][j] = pathNum[i + 1][j] + pathNum[i][j + 1];
                }
            }
        }

        return pathNum[0][0];
    }
}
