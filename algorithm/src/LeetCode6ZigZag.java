/*
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

public class LeetCode6ZigZag {
    public String convert(String s, int numRows) {
        int point = 0;
        int len = s.length();
        if (len == 0) {
            return "";
        }

        if (numRows == 1) {
            return s;
        }

        int maxRow = numRows;
        int maxCol = (1 + len / (2 * numRows -2)) * (numRows - 1);
        char[][] matrix = new char[maxRow][maxCol];
        char none = matrix[0][0];
        int nowRow = 0;
        int nowCol = 0;
        boolean isDown = true;
        char[] chars = s.toCharArray();
        String result = "";

        while (point < len) {
            if (isDown == true) {
                if (nowRow < maxRow) {
                    matrix[nowRow][nowCol] = chars[point];
                    nowRow++;
                    point++;        // 只有在成功赋值后才移动指针
                } else {
                    nowRow--;   // 多走了1步
                    nowRow--;   // 向左上角走一步
                    nowCol++;
                    isDown = false;
                }
            } else {
                if (nowRow >= 0) {
                    matrix[nowRow][nowCol] = chars[point];
                    nowRow--;
                    nowCol++;
                    point++;
                } else {
                    nowRow++;
                    nowRow++;   // 多走了1步
                    nowCol--;   // 向下走一步
                    isDown = true;
                }
            }

        }

        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (matrix[i][j] != none) {
                    result += matrix[i][j];
                }
            }
        }

        return result;
    }
}
