/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        boolean[][] isUsed = new boolean[2][3];
//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
        int[] nums = {3,1};
        int target = 1;
//        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int result = new LeetCode33SearchRotatedSortedArray().search(nums, target);
        System.out.println(result);



    }

}
