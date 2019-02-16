/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        boolean[][] isUsed = new boolean[2][3];
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = new LeetCode79WordSearch().exist(board, word);
        System.out.println(result);

    }

}
