import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new LeetCode46Permutations().permute(nums);
        System.out.println(result);
    }
}
