/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
//        boolean[][] isUsed = new boolean[2][3];

        int[][] a = new int[3][3];
        a[1][1] = 1;

        int result = new LeetCode63UniquePathsII().uniquePathsWithObstacles(a);
        System.out.println(result);
    }

}
