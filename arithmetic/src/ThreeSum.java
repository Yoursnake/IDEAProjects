import java.util.*;

/**
 * Created by shengliyi on 2017/3/7.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) continue;
            if (i>0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> intList = new ArrayList<>();
                    intList.add(nums[i]);
                    intList.add(nums[begin]);
                    intList.add(nums[end]);
                    listList.add(intList);
                    begin++; end--;
                    while (nums[begin] == nums[begin - 1]) begin++;
                    while (nums[end] == nums[end + 1]) end--;
                } else if (sum > 0) end--;
                else begin++;
            }
        }
        
        return listList;
    }


}
