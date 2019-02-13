/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
//        boolean[][] isUsed = new boolean[2][3];
        int[][] a = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        boolean b = new LeetCode74Searcha2DMatrix().searchMatrix(a, 24);
        System.out.println(b);

}

}
