/**
 * Created by shengliyi on 2017/3/4.
 */

public class Main {
//-2147483648
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = new LeetCode53MaximumSubarray().maxSubArray(nums);
        System.out.println(result);
    }
}
