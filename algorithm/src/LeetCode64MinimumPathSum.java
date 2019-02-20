public class LeetCode64MinimumPathSum {
    // 动态规划
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] pathSum = new int[row][col];

        pathSum[row - 1][col - 1] = grid[row - 1][col - 1];

        // 初始化边界
        for (int i = row - 2; i >= 0; i--) {
            pathSum[i][col - 1] = grid[i][col - 1] + pathSum[i + 1][col - 1];
        }

        for (int i = col - 2; i >= 0; i--) {
            pathSum[row - 1][i] = grid[row - 1][i] + pathSum[row - 1][i + 1];
        }

        // 补全表格
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                pathSum[i][j] = Math.min(grid[i][j] + pathSum[i + 1][j],
                        grid[i][j] + pathSum[i][j + 1]);
            }
        }

        return pathSum[0][0];
    }
}
