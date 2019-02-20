import java.util.Arrays;

/**
 * Created by shengliyi on 2017/3/11.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int sum = nums[0]+nums[1]+nums[2];
        int diff = Math.abs(sum - target);
        Arrays.sort(nums);
        for (int i = 0;i < nums.length-2;i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int newSum = nums[i]+nums[left]+nums[right];
                if (Math.abs(newSum - target) < diff) {
                    diff = Math.abs(newSum - target);
                    sum = newSum;
                }
                if (newSum > target) right--;
                else left++;
            }
        }
        return sum;
    }
}
