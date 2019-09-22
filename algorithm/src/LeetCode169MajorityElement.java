/*
Given an array of size n, find the majority element. The majority element
is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always
exist in the array.

Example 1:

Input: [3,2,3]
Output: 3

Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2

 */

import java.util.Arrays;

public class LeetCode169MajorityElement {
//    // 使用 HashMap 时间复杂度为 O(n^2) 34.86%
//    public int majorityElement(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                int count = map.get(num) + 1;
//                if (count > nums.length / 2) return num;
//                map.put(num, count);
//            } else {
//                map.put(num, 1);
//            }
//        }
//
//        return -1;
//    }

//    // 使用排序，时间复杂度 O(nlogn)    5%
//    public int majorityElement(int[] nums) {
//        quickSort(nums, 0, nums.length - 1);
//        return nums[nums.length / 2];
//    }
//
//    public void quickSort(int[] nums, int begin, int end) {
//        if (begin > end) return;
//
//        int flag = nums[begin];
//        int left = begin;
//        int right = end;
//
//        while (true) {
//            // 顺序不能错，最终停下的位置才能比flag小
//            while (left < right && nums[right] >= flag) right--;
//            while (left < right && nums[left] <= flag) left++;
//            if (left >= right) break;
//            int temp = nums[left];
//            nums[left] = nums[right];
//            nums[right] = temp;
//        }
//
//        nums[begin] = nums[right];
//        nums[right] = flag;
//        quickSort(nums, begin, right - 1);
//        quickSort(nums, right + 1, end);
//    }

    // // sort: 99%
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }

	// moore voting: 99%
    public int majorityElement(int[] nums) {
    	int cnt = 0;
    	int res = 0;

    	for (int i = 0; i < nums.length; i++) {
    		if (num == res) {
    			cnt++;
    		} else if (cnt == 0) {
    			res = num;
    			cnt = 1;
    		} else {
    			cnt--;
    		}
    	}

		return res;
    }
}
