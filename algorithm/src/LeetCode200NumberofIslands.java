/*
Given a 2d grid map of '1's (land) and '0's (water), count the
number of islands. An island is surrounded by water and is formed
by connecting adjacent lands horizontally or vertically. You may
assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

public class LeetCode200NumberofIslands {
    // DFS 47%
//    public int numIslands(char[][] grid) {
//        if (grid.length == 0) return 0;
//
//        int row = grid.length;
//        int col = grid[0].length;
//        int result = 0;
//        boolean[][] visited = new boolean[row][col];
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (visited[i][j] || grid[i][j] == '0') {
//                    continue;
//                } else {
//                    result++;
//                    DFS(grid, visited, i, j);
//                }
//            }
//        }
//
//        return result;
//    }
//
//    private void DFS(char[][] grid, boolean[][] visited, int x, int y) {
//        if (x < 0 || x >= grid.length) return;
//        if (y < 0 || y >= grid[0].length) return;
//        if (visited[x][y] || grid[x][y] == '0') return;
//
//        visited[x][y] = true;
//        DFS(grid, visited, x - 1, y);
//        DFS(grid, visited, x + 1, y);
//        DFS(grid, visited, x, y - 1);
//        DFS(grid, visited, x, y + 1);
//    }

    // DFS 100%，比上面的方法少了个 visited 的赋值时间和内存空间
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    DFS(grid, i, j);
                }
            }
        }

        return result;
    }

    // 把 1 的整块部分变成 0，相当于把小岛腐蚀掉
    private void DFS(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) return;
        if (y < 0 || y >= grid[0].length) return;
        if (grid[x][y] == '0') return;

        grid[x][y] = '0';
        DFS(grid, x - 1, y);
        DFS(grid, x + 1, y);
        DFS(grid, x, y - 1);
        DFS(grid, x, y + 1);
    }
}
