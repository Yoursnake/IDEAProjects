import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shengliyi on 2017/3/11.
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
//        int pre_i = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {

//            if(pre_i == nums[i]){
//                continue;     //如果上一个数和当前的数一致则跳过
//            }
//            pre_i = nums[i];  //  记录上一个数
//            if(4*nums[i] > target){
//                break;
//            }
//            if(nums[i] + 3*nums[i+1] > target || nums[i] + 3*nums[nums.length-1] < target){
//                continue;
//            }
            if (i>0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            while(j < nums.length - 2) {

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> intList = new ArrayList<>();
                        intList.add(nums[i]);
                        intList.add(nums[j]);
                        intList.add(nums[left]);
                        intList.add(nums[right]);
//                        Integer[] temp = {nums[i],nums[j],nums[left],nums[right]};
//                        listList.add(Arrays.asList(temp));
                    }
                    if (sum < target) {
                        left++;
                        while (nums[left] == nums[left-1] && left < right) left++;
                    }
                    else {
                        right--;
                        while (nums[right] == nums[right+1] && left < right) right--;
                    }

                }
                j++;
                while(nums[j] == nums[j-1] && j<nums.length-2) j++;
            }
        }
        return listList;
    }
}
