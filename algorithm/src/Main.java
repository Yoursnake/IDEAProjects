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

    @Test
	public void LeetCode381() {
	    LeetCode381InsertDeleteGetRandomO1Duplicatesallowed obj = new LeetCode381InsertDeleteGetRandomO1Duplicatesallowed();
	    boolean param1 = obj.insert(1);
	    boolean param2 = obj.remove(1);
	    boolean param3 = obj.insert(1);
	    System.out.println(param1 + "\t" + param2 + "\t" + param3);
    }

}
