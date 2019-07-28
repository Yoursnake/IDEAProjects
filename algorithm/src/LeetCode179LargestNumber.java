/*
Given a list of non negative integers, arrange them such
that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"

Note: The result may be very large, so you need to return
a string instead of an integer.
 */

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode179LargestNumber {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int l1 = (o1 == 0) ? 1 : (int) (Math.log10(o1) + 1);
                int l2 = (o2 == 0) ? 1 : (int) (Math.log10(o2) + 1);

                if (o1 * Math.pow(10, l2) + o2 > o2 * Math.pow(10, l1) + o1) return -1;
                else if (o1 * Math.pow(10, l2) + o2 < o2 * Math.pow(10, l1) + o1) return 1;
                else return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        String result = sb.toString();
        return (result.charAt(0) == '0') ? "0" : result;
    }
}
