/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        int result = new LeetCode152MaximumProductSubarray().maxProduct(nums);
        System.out.println(result);
    }
}
