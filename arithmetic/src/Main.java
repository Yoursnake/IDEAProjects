import java.util.List;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    public static void main(String[] args) {

        int[] candidadtes = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = new LeetCode40CombinationSumII().combinationSum2(candidadtes, target);
        System.out.println(result);
    }
}
