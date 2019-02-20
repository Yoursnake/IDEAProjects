/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

public class LeetCode79WordSearch {
//    public boolean exist(char[][] board, String word) {
//        int row = board.length;
//        int col = board[0].length;
//        char firstChar = word.charAt(0);
//        boolean[][] isUsed = new boolean[row][col];
//
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (board[i][j] == firstChar) {
//                    if (word.length() == 1) return true;
//
//                    isUsed[i][j] = true;
//                    // 不能直接 return findWord(...)，不然后面找不到就直接不往后找了
//                    if (findWord(isUsed, board, word, new int[]{i, j}, 1)) {
//                        return true;
//                    }
//                    isUsed[i][j] = false;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    private boolean findWord(boolean[][] isUsed, char[][] board, String word, int[] coord, int index) {
//        char nowChar = word.charAt(index);
//        int x = coord[0];
//        int y = coord[1];
//
//        List<int[]> coordList = new ArrayList<>();
//
//        if (x > 0 && !isUsed[x - 1][y]) {
//            coordList.add(new int[]{x - 1, y});
//        }
//
//        if (x < board.length - 1 && !isUsed[x + 1][y]) {
//            coordList.add(new int[]{x + 1, y});
//        }
//
//        if (y > 0 && !isUsed[x][y - 1]) {
//            coordList.add(new int[]{x, y - 1});
//        }
//
//        if (y < board[0].length - 1 && !isUsed[x][y + 1]) {
//            coordList.add(new int[]{x, y + 1});
//        }
//
//        for (int[] adjCoord : coordList) {
//            if (board[adjCoord[0]][adjCoord[1]] == nowChar) {
//                isUsed[adjCoord[0]][adjCoord[1]] = true;
//
//                if (index == word.length() - 1) {
//                    return true;
//                } else {
//                    // 不能直接 return findWord(...) 原因同上
//                    if (findWord(isUsed, board, word, adjCoord, index + 1)) {
//                        return true;
//                    }
//                }
//
//                isUsed[adjCoord[0]][adjCoord[1]] = false;
//            }
//        }
//
//        return false;
//    }

    // 这和上面算法思想是一样的，但更优雅，速度也稍快 19ms -> 11ms
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] isUsed = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (findWord(isUsed, board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean findWord(boolean[][] isUsed, char[][] board, String word, int x, int y, int index) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        } else {
            if (board[x][y] == word.charAt(index)) {
                // 使用这个二维数字会优雅许多
                int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
                isUsed[x][y] = true;
                for (int i = 0; i < 4; i++) {
                    int newX = x + d[i][0];
                    int newY = y + d[i][1];
                    // 顺序不能错，因为只有在区域中才能使用 isUsed 数组
                    if (inArea(board, newX, newY) && !isUsed[newX][newY] && findWord(isUsed, board, word, newX, newY, index + 1)) {
                        return true;
                    }
                }
                isUsed[x][y] = false;
            }
            return false;
        }
    }

    // x y 是否在数组中
    private boolean inArea(char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;

        if (x >= 0 && x < row && y >= 0 && y < col) {
            return true;
        } else {
            return false;
        }
    }

}
