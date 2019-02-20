/**
 * Created by shengliyi on 2017/3/9.
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        int[] nums = new int[41];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }
}
