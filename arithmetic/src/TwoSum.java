/**
 * Created by shengliyi on 2017/3/4.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int i,j = 0;
        a:
        for (i = 0; i < size-1; i++) {
            for (j = i+1; j < size; j++) {
                if (target == nums[i] + nums[j]) {
                    break a;
                }
            }
        }
        return new int[]{i, j};
    }
}
