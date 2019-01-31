import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = new LeetCode47PermutationsII().permuteUnique(nums);
        System.out.println(result);
    }
}
