import org.junit.Test;

/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {

    @Test
	public void LeetCode377() {
	    int[] nums = {2, 1, 3};
	    int target = 35;

	    int res = new LeetCode377CombinationSumIV().combinationSum4(nums, target);
	    System.out.println(res);
    }

}
