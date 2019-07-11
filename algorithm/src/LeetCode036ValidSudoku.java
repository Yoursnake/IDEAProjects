/*
Example 1

Input:
{
        {'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
}
Output: true

Example 2

Input:
{
        {'8','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}
}
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner
being modified to 8. Since there are two 8's in the top left 3x3 sub-box,
it is invalid.

rule
1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9
   without repetition.
 */

public class LeetCode036ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int rowLen = board.length;
        int colLen = board.length;

        // 检查行
        for (int i = 0; i < rowLen; i++) {
            int[] counter = new int[colLen];

            for (int j = 0; j < colLen; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    counter[num]++;
                    if (counter[num] > 1) {
                        return false;
                    }
                }
            }
        }

        // 检查列
        for (int i = 0; i < colLen; i++) {
            int[] counter = new int[rowLen];

            for (int j = 0; j < rowLen; j++) {
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0' - 1;
                    counter[num]++;
                    if (counter[num] > 1) {
                        return false;
                    }
                }
            }
        }

        // 检查 3 * 3
        int cellNum = colLen * rowLen / (3 * 3);
        for (int i = 0; i < cellNum; i++) {
            int[] counter = new int[3 * 3];

            for (int j = 3 * (i / 3); j < 3 * (i / 3) + 3; j++) {
                for (int k = 3 * (i % 3); k < 3 * (i % 3) + 3; k++) {
                    if (board[j][k] != '.') {
                        int num = board[j][k] - '0' - 1;
                        counter[num]++;
                        if (counter[num] > 1) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
