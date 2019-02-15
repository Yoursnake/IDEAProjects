import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
//        boolean[][] isUsed = new boolean[2][3];
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new LeetCode78Subsets().subsets(nums);
        System.out.println(result);
    }

}
