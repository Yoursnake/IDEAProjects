import java.util.ArrayList;
import java.util.List;

public class LeetCode052NQueensII {
    public int totalNQueens(int n) {
        List<String> curr = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();

        nQueens(result, curr, 0, n);

        return result.size();
    }

    // 回溯法就完事了
    private void nQueens(List<List<String>> result, List<String> curr, int index, int n) {
        if (index == n) {
            result.add(curr);
            return;
        }

        // 初始化一行
        char[] row = new char[n];
        for (int i = 0; i < row.length; i++) {
            row[i] = '.';
        }

        // 一行可以下的地方
        boolean[] canStay = new boolean[n];
        for (int i = 0; i < canStay.length; i++) {
            canStay[i] = true;
        }

        for (int i = 0; i < curr.size(); i++) {
            int indexQ = curr.get(i).indexOf('Q');
            canStay[indexQ] = false;
            int leftIndex = indexQ - (index - i);
            int rightIndex = indexQ + (index - i);

            if (leftIndex >= 0) canStay[leftIndex] = false;
            if (rightIndex < n) canStay[rightIndex] = false;
        }

        for (int i = 0; i < row.length; i++) {
            if (canStay[i]) {
                row[i] = 'Q';
                List<String> temp = new ArrayList<>(curr);
                temp.add(new String(row));
                nQueens(result, temp, index + 1, n);
                row[i] = '.';   // 注意这个row要还原
            }
        }
    }
}
